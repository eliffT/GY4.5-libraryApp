package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.author.AuthorSimpleDto;
import com.turkcell.libraryapp.dto.book.BookForAddDto;
import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.dto.publisher.PublisherSimpleDto;
import com.turkcell.libraryapp.entity.Author;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.entity.Publisher;
import com.turkcell.libraryapp.repository.AuthorRepository;
import com.turkcell.libraryapp.repository.BookRepository;
import com.turkcell.libraryapp.repository.CategoryRepository;
import com.turkcell.libraryapp.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<BookForGetDto> getAllWithDto(){
        List<Book> bookList =  bookRepository.findAll();
        List<BookForGetDto> bookForGetDtoList = new ArrayList<BookForGetDto>();
        for(Book book : bookList){
            BookForGetDto bookForGetDto = new BookForGetDto();
            bookForGetDto.setTitle(book.getTitle());
            bookForGetDto.setLanguage(book.getLanguage());
            bookForGetDto.setYear(book.getYear());
            bookForGetDto.setStock(book.getStock());

            if (book.getAuthor() != null) {
                AuthorSimpleDto authorDto = new AuthorSimpleDto();
                authorDto.setId(book.getAuthor().getId());
                authorDto.setFirstName(book.getAuthor().getFirstName());
                authorDto.setLastName(book.getAuthor().getLastName());
                bookForGetDto.setAuthor(authorDto);
            }

            if (book.getPublisher() != null) {
                PublisherSimpleDto publisherDto = new PublisherSimpleDto();
                publisherDto.setId(book.getPublisher().getId());
                publisherDto.setName(book.getPublisher().getName());
                bookForGetDto.setPublisher(publisherDto);
            }

            CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
            categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
            bookForGetDto.setCategoryForGetDto(categoryForGetDto);

            bookForGetDtoList.add(bookForGetDto);
        }
        return bookForGetDtoList;
    }

    public BookForGetDto addWithDto(@Valid BookForAddDto bookForAddDto){
        Book book = new Book();
        book.setTitle(bookForAddDto.getTitle());
        book.setLanguage(bookForAddDto.getLanguage());
        book.setYear(bookForAddDto.getYear());
        book.setStock(bookForAddDto.getStock());

        Category category = categoryRepository.findById(bookForAddDto.getCategoryId()).orElseThrow();
        book.setCategory(category);

        Author author = authorRepository.findById(bookForAddDto.getAuthorId()).orElseThrow();
        book.setAuthor(author);

        Publisher publisher = publisherRepository.findById(bookForAddDto.getPublisherId()).orElseThrow();
        book.setPublisher(publisher);

        Book bookSaved = this.bookRepository.save(book);

        BookForGetDto bookForGetDto = new BookForGetDto();
        bookForGetDto.setTitle(bookSaved.getTitle());
        bookForGetDto.setLanguage(bookSaved.getLanguage());
        bookForGetDto.setYear(bookSaved.getYear());
        bookForGetDto.setStock(bookSaved.getStock());

        if (bookSaved.getAuthor() != null) {
            AuthorSimpleDto authorDto = new AuthorSimpleDto();
            authorDto.setId(bookSaved.getAuthor().getId());
            authorDto.setFirstName(bookSaved.getAuthor().getFirstName());
            authorDto.setLastName(bookSaved.getAuthor().getLastName());
            bookForGetDto.setAuthor(authorDto);
        }

        if (bookSaved.getPublisher() != null) {
            PublisherSimpleDto publisherDto = new PublisherSimpleDto();
            publisherDto.setId(bookSaved.getPublisher().getId());
            publisherDto.setName(bookSaved.getPublisher().getName());
            bookForGetDto.setPublisher(publisherDto);
        }

        CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
        categoryForGetDto.setCategoryName(bookSaved.getCategory().getCategoryName());

        bookForGetDto.setCategoryForGetDto(categoryForGetDto);

        return bookForGetDto;
    }

    public BookForGetDto getByIdWithDto(Integer id){
        Book book = bookRepository.findById(id).orElseThrow();
        BookForGetDto dto = new BookForGetDto();
        dto.setTitle(book.getTitle());
        dto.setLanguage(book.getLanguage());
        dto.setYear(book.getYear());
        dto.setStock(book.getStock());

        // Basit DTO'lar oluştur - null kontrolü ile
        if (book.getAuthor() != null) {
            AuthorSimpleDto authorDto = new AuthorSimpleDto();
            authorDto.setId(book.getAuthor().getId());
            authorDto.setFirstName(book.getAuthor().getFirstName());
            authorDto.setLastName(book.getAuthor().getLastName());
            dto.setAuthor(authorDto);
        }

        if (book.getPublisher() != null) {
            PublisherSimpleDto publisherDto = new PublisherSimpleDto();
            publisherDto.setId(book.getPublisher().getId());
            publisherDto.setName(book.getPublisher().getName());
            dto.setPublisher(publisherDto);
        }

        CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
        categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
        dto.setCategoryForGetDto(categoryForGetDto);
        return dto;
    }

    public void deleteBookWithById(Integer id){
        bookRepository.deleteById(id);
    }

    public List<BookForGetDto> findByLanguage(String language){
        List<Book> bookList = bookRepository.findByLanguage(language);
        List<BookForGetDto> bookForGetDtoList = new ArrayList<BookForGetDto>();
        for (Book book: bookList){
            BookForGetDto bookForGetDto = new BookForGetDto();
            bookForGetDto.setTitle(book.getTitle());
            bookForGetDto.setLanguage(book.getLanguage());
            bookForGetDto.setYear(book.getYear());
            bookForGetDto.setStock(book.getStock());

            if (book.getAuthor() != null) {
                AuthorSimpleDto authorDto = new AuthorSimpleDto();
                authorDto.setId(book.getAuthor().getId());
                authorDto.setFirstName(book.getAuthor().getFirstName());
                authorDto.setLastName(book.getAuthor().getLastName());
                bookForGetDto.setAuthor(authorDto);
            }

            if (book.getPublisher() != null) {
                PublisherSimpleDto publisherDto = new PublisherSimpleDto();
                publisherDto.setId(book.getPublisher().getId());
                publisherDto.setName(book.getPublisher().getName());
                bookForGetDto.setPublisher(publisherDto);
            }

            CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
            categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
            bookForGetDto.setCategoryForGetDto(categoryForGetDto);

            bookForGetDtoList.add(bookForGetDto);
        }
        return bookForGetDtoList;
    }

    public List<BookForGetDto> highValueOfStock(){
        List<Book> bookList = bookRepository.highValueOfStock();
        List<BookForGetDto> bookForGetDtoList = new ArrayList<BookForGetDto>();
        for (Book book: bookList){
            BookForGetDto bookForGetDto = new BookForGetDto();
            bookForGetDto.setTitle(book.getTitle());
            bookForGetDto.setLanguage(book.getLanguage());
            bookForGetDto.setYear(book.getYear());
            bookForGetDto.setStock(book.getStock());

            if (book.getAuthor() != null) {
                AuthorSimpleDto authorDto = new AuthorSimpleDto();
                authorDto.setId(book.getAuthor().getId());
                authorDto.setFirstName(book.getAuthor().getFirstName());
                authorDto.setLastName(book.getAuthor().getLastName());
                bookForGetDto.setAuthor(authorDto);
            }

            if (book.getPublisher() != null) {
                PublisherSimpleDto publisherDto = new PublisherSimpleDto();
                publisherDto.setId(book.getPublisher().getId());
                publisherDto.setName(book.getPublisher().getName());
                bookForGetDto.setPublisher(publisherDto);
            }

            CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
            categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
            bookForGetDto.setCategoryForGetDto(categoryForGetDto);

            bookForGetDtoList.add(bookForGetDto);
        }
        return bookForGetDtoList;
    }


}
