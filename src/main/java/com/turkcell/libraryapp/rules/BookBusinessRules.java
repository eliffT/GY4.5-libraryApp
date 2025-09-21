package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.entity.Book;
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


}
