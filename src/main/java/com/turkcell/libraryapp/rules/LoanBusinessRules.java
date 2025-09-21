package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumList.BookStatus;
import com.turkcell.libraryapp.entity.enumList.LoanStatus;
import com.turkcell.libraryapp.repository.LoanRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoanBusinessRules {

    private final LoanRepository loanRepository;
    private final FineBusinessRules fineBusinessRules;
    private final UserBusinessRules userBusinessRules;
    private final BookBusinessRules bookBusinessRules;

    public LoanBusinessRules(LoanRepository loanRepository, FineBusinessRules fineBusinessRules, UserBusinessRules userBusinessRules, BookBusinessRules bookBusinessRules) {
        this.loanRepository = loanRepository;
        this.fineBusinessRules = fineBusinessRules;
        this.userBusinessRules = userBusinessRules;
        this.bookBusinessRules = bookBusinessRules;
    }

    public void loanRules(Book book, User user) {

        // Member aktif mi?
        String status = userBusinessRules.checkUserStatus(user);
        if(!("ACTIVE".equals(status))){
            throw new RuntimeException("User is not active");
        }

        // Kitap stok kontrolü ve status = ACTIVE
        bookBusinessRules.checkAvailableCopies(book);
        bookBusinessRules.checkBookStatus(book);

        // Kullanıcının ödenmemiş cezası var mı ?
        fineBusinessRules.validateUserHasUnpaidFines(user);

        // Açık ödünç sayısı limiti aştı mı?
        List<LoanStatus> loanStatusList = Arrays.asList(LoanStatus.BORROWED, LoanStatus.LATE);
        int countLoans = loanRepository.countByUserIdAndStatusIn(user.getId(), loanStatusList);

        if (countLoans >= user.getMembershipLevel().getMaxLoans()) {
            throw new RuntimeException("User has reached the maximum allowed active loans");
        }

        // Üyenin kitap için açık loan'ı var mı?
        boolean checkActiveLoan = loanRepository.existsByUser_IdAndBook_IdAndReturnDateIsNull(user.getId(), book.getId());

        if (checkActiveLoan) {
            throw new RuntimeException("User already has an active loan for this book.");
        }

    }

    // dueDate hesaplama
    public LocalDate calculateDueDate(User user, LocalDate borrowDate) {
        int loanDays = user.getMembershipLevel().getLoanDays();
        return borrowDate.plusDays(loanDays);
    }

    // iade edilebilme durumu kontrolü
    public void validateLoanIsReturnable(Loan loan) {
        if (!(loan.getStatus().equals(LoanStatus.BORROWED) || loan.getStatus().equals(LoanStatus.LATE))) {
            throw new RuntimeException("Invalid transaction: Loan is not active or already returned.");
        }
    }

    // status = OPEN ise BORROWED ve LATE iki durumu da alması için bir iş kuralı.
    public List<LoanStatus> convertStatusToLoanStatus(String status) {
        List<LoanStatus> loanStatusList = new ArrayList<>();
        if ("OPEN".equalsIgnoreCase(status)) {
            loanStatusList = List.of(LoanStatus.BORROWED, LoanStatus.LATE);
        } else {
            loanStatusList = List.of(LoanStatus.valueOf(status.toUpperCase()));
        }
        return loanStatusList;
    }

}
