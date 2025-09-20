package com.turkcell.libraryapp.service;
import com.turkcell.libraryapp.dto.loan.request.LoanRequest;
import com.turkcell.libraryapp.dto.loan.request.LoanReturnRequest;
import com.turkcell.libraryapp.dto.loan.response.LoanResponse;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Fine;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumList.LoanStatus;
import com.turkcell.libraryapp.mapper.LoanMapper;
import com.turkcell.libraryapp.repository.BookRepository;
import com.turkcell.libraryapp.repository.FineRepository;
import com.turkcell.libraryapp.repository.LoanRepository;
import com.turkcell.libraryapp.repository.UserRepository;
import com.turkcell.libraryapp.rules.FineBusinessRules;
import com.turkcell.libraryapp.rules.LoanBusinessRules;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final LoanMapper loanMapper;
    private final LoanBusinessRules loanBusinessRules;
    private final FineBusinessRules fineBusinessRules;
    private final FineRepository fineRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository,
                       UserRepository userRepository, LoanMapper loanMapper, LoanBusinessRules loanBusinessRules,
                       FineBusinessRules fineBusinessRules, FineRepository fineRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.loanMapper = loanMapper;
        this.loanBusinessRules = loanBusinessRules;
        this.fineBusinessRules = fineBusinessRules;
        this.fineRepository = fineRepository;
    }

    public LoanResponse createLoan(LoanRequest request) {

        // Get User and Book
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));
        Book book = bookRepository.findById(request.getBookId()).orElseThrow(() -> new NotFoundException("Book not found"));

        // Business Rule
        loanBusinessRules.loanRules(book, user);

        // DTO - Entity
        Loan loan = loanMapper.LoanRequestToLoan(request);

        // Loan Operations
        loan.setBook(book);
        loan.setUser(user);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(loanBusinessRules.calculateDueDate(user, loan.getBorrowDate()));
        loan.setStatus(LoanStatus.BORROWED);

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        loanRepository.save(loan);
        bookRepository.save(book);

        return loanMapper.loanToLoanResponse(loan);
    }

    public LoanResponse returnLoan(LoanReturnRequest request){

        Loan loan = loanRepository.findById(request.getId())
                .orElseThrow(() -> new NotFoundException("Loan not found"));

        // Loan durumunun iade edilebilir olup olmadığını kontrol edilir
        loanBusinessRules.validateLoanIsReturnable(loan);

        loan.setReturnDate(LocalDate.now());

        // Gecikme ücreti hesaplanır
        double fineAmount = fineBusinessRules.calculateLateFee(loan.getDueDate(), loan.getReturnDate());

        if (fineAmount > 0) {
            Fine fine = new Fine();
            fine.setLoan(loan);
            fine.setAmount(fineAmount);
            fine.setPaid(false);
            fineRepository.save(fine);

            loan.setStatus(LoanStatus.LATE);
            loan.getFineList().add(fine);
        }else {
            loan.setStatus(LoanStatus.RETURNED);
        }

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        loanRepository.save(loan);
        bookRepository.save(book);

        return loanMapper.loanToLoanResponse(loan);
    }

    public List<LoanResponse> getAllLoans() {
        return loanMapper.loanToLoanResponsesList(loanRepository.findAll());

    }

    public LoanResponse getLoanById(Integer id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return loanMapper.loanToLoanResponse(loan);
    }

    public LoanResponse updateLoan(Integer id, LoanRequest request) {
        Loan loan = loanRepository.findById(id).orElseThrow();

        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        loan.setBook(book);
        loan.setUser(user);

        Loan updated = loanRepository.save(loan);
        return loanMapper.loanToLoanResponse(updated);
    }

    public void deleteLoan(Integer id) {
        loanRepository.deleteById(id);
    }

    public List<LoanResponse> getLoansByUserIdAndStatusIn(Integer userId, String status) {
        List<LoanStatus> loanStatusList = loanBusinessRules.convertStatusToLoanStatus(status);
        List<Loan> loanList = loanRepository.findByUser_IdAndStatusIn(userId, loanStatusList);
        return loanMapper.loanToLoanResponsesList(loanList);
    }

}
