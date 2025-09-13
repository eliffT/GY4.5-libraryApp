package com.turkcell.libraryapp.service;
import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.loan.request.LoanRequest;
import com.turkcell.libraryapp.dto.loan.response.LoanResponse;
import com.turkcell.libraryapp.dto.user.response.UserResponse;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.User;
import com.turkcell.libraryapp.entity.enumarations.LoanStatus;
import com.turkcell.libraryapp.repository.BookRepository;
import com.turkcell.libraryapp.repository.LoanRepository;
import com.turkcell.libraryapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public LoanResponse addWithDto(LoanRequest request) {
        Loan loan = new Loan();
        loan.setBorrowDate(request.getBorrowDate());
        loan.setDueDate(request.getDueDate());
        loan.setReturnDate(request.getReturnDate());
        loan.setStatus(request.getStatus());
        //loan.setStatus(request.getStatus() != null ? request.getStatus() : LoanStatus.BORROWED);


        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        loan.setBook(book);
        loan.setUser(user);

        Loan saved = loanRepository.save(loan);

        return convertToDto(saved);
    }

    public List<LoanResponse> getAllWithDto() {
        List<Loan> loans = loanRepository.findAll();
        List<LoanResponse> result = new ArrayList<>();

        for (Loan loan : loans) {
            result.add(convertToDto(loan));
        }
        return result;
    }

    public LoanResponse getByIdWithDto(Integer id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return convertToDto(loan);
    }

    public LoanResponse updateWithDto(Integer id, LoanRequest request) {
        Loan loan = loanRepository.findById(id).orElseThrow();

        loan.setBorrowDate(request.getBorrowDate());
        loan.setDueDate(request.getDueDate());
        loan.setReturnDate(request.getReturnDate());
        loan.setStatus(request.getStatus());
        //loan.setStatus(request.getStatus() != null ? request.getStatus() : LoanStatus.BORROWED);


        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        loan.setBook(book);
        loan.setUser(user);


        Loan updated = loanRepository.save(loan);
        return convertToDto(updated);
    }

    public void deleteById(Integer id) {
        loanRepository.deleteById(id);
    }

    private LoanResponse convertToDto(Loan loan) {
        LoanResponse dto = new LoanResponse();
        dto.setId(loan.getId());
        dto.setBorrowDate(loan.getBorrowDate());
        dto.setDueDate(loan.getDueDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setStatus(loan.getStatus());

        //loan kaydının mutlaka bir kullanıcıya bağlı olacağı garanti değil bundan dolayı,
        //yalnızca user gerçekten varsa userdto döndür
        if (loan.getUser() != null) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(loan.getUser().getId());
            userResponse.setName(loan.getUser().getFirstName());
            userResponse.setLastName(loan.getUser().getLastName());
            userResponse.setEmail(loan.getUser().getEmail());
            userResponse.setPhone(loan.getUser().getPhone());
            userResponse.setRole(loan.getUser().getRole());
            userResponse.setActive(loan.getUser().getActive());
            userResponse.setCreatedAt(loan.getUser().getCreatedAt());
            dto.setUser(userResponse);
        }

        // Loan’a bağlı kitap olmayabilir kontrol ederek var olan kitabı fto ya yolluoyurz
        if (loan.getBook() != null) {
            BookForGetDto bookResponse = new BookForGetDto();
            bookResponse.setTitle(loan.getBook().getTitle());
            bookResponse.setYear(loan.getBook().getYear());
            bookResponse.setLanguage(loan.getBook().getLanguage());
            bookResponse.setStock(loan.getBook().getStock());

            if (loan.getBook().getCategory() != null) {
                com.turkcell.libraryapp.dto.category.CategoryForGetDto categoryDto = new com.turkcell.libraryapp.dto.category.CategoryForGetDto();
                categoryDto.setCategoryName(loan.getBook().getCategory().getCategoryName());
                bookResponse.setCategoryForGetDto(categoryDto);
            }

            if (loan.getBook().getAuthor() != null) {
                com.turkcell.libraryapp.dto.author.AuthorSimpleDto authorDto = new com.turkcell.libraryapp.dto.author.AuthorSimpleDto();
                authorDto.setId(loan.getBook().getAuthor().getId());
                authorDto.setFirstName(loan.getBook().getAuthor().getFirstName());
                authorDto.setLastName(loan.getBook().getAuthor().getLastName());
                bookResponse.setAuthor(authorDto);
            }

            if (loan.getBook().getPublisher() != null) {
                com.turkcell.libraryapp.dto.publisher.PublisherSimpleDto publisherDto = new com.turkcell.libraryapp.dto.publisher.PublisherSimpleDto();
                publisherDto.setId(loan.getBook().getPublisher().getId());
                publisherDto.setName(loan.getBook().getPublisher().getName());
                bookResponse.setPublisher(publisherDto);
            }

            dto.setBook(bookResponse);
        }

        return dto;
    }

}
