package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.core.utils.ISBNGenerator;
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

    // ISBN numarasını kontrol et ve üret
    public String generateUniqueISBN() {
        String isbn;
        do {
            isbn = ISBNGenerator.generateTimestampBasedISBN();  // ISBN generator'ı kullanıyoruz
        } while (isIsbnExist(isbn));  // ISBN mevcutsa, tekrar üret
        return isbn;
    }

    // Mevcut kitaplarda bu ISBN numarasının olup olmadığını kontrol et
    private boolean isIsbnExist(String isbn) {
        return bookRepository.existsByIsbn(isbn);
    }

    public void checkBookStatus(Book book)
    {
        if (!book.getStatus().equals(BookStatus.ACTIVE)){
            throw new RuntimeException("Book is not active");
        }
    }

    public void checkTotalCopies(Book book){

        if(book.getTotalCopies() < 0){
            throw new IllegalArgumentException("Total copies cannot be less than zero.");
        }
        if(book.getTotalCopies() < book.getAvailableCopies()){
            throw new IllegalArgumentException("Available copies cannot exceed total copies");
        }
    }

    public  void checkAvailableCopies(Book book)
    {
        if (book.getAvailableCopies() <= 0) {
            throw new IllegalArgumentException("No available copies to borrow");
        }
    }

}
