package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.enumList.BookStatus;
import com.turkcell.libraryapp.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookBusinessRules {
    private final BookRepository bookRepository;

    public BookBusinessRules(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void bookShouldNotExistWithSameTitleAndLanguage(String title, String language) {
        Book bookWithSameTitleAndLanguage =
                bookRepository.findByTitleIgnoreCaseAndLanguageIgnoreCase(title, language)
                        .orElse(null);

        if (bookWithSameTitleAndLanguage != null) {
            throw new RuntimeException("Bu başlık ve dil ile zaten bir kitap zaten ekli.");
        }
    }

    public void checkBookStatus(Book book)
    {
        if (!book.getStatus().equals(BookStatus.ACTIVE)){
            throw new RuntimeException("Book is not active");
        }
    }

    public void checkAvailableCopies(Book book){

        if(book.getTotalCopies() < 0){
            throw new RuntimeException("No total copies for this book");
        }
        if(book.getTotalCopies() < book.getAvailableCopies()){
            throw new RuntimeException("Available copies cannot exceed total copies");
        }
    }

    public  void checkTotalCopies(Book book)
    {
        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("No copies available for this book");
        }
    }

    public void validateBook(Book book){
        checkBookStatus(book);
        checkTotalCopies(book);
        checkAvailableCopies(book);
    }
}
