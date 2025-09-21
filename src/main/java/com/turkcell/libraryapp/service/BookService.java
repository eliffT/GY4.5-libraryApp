package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.book.request.BookRequest;
import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.entity.Author;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.entity.Publisher;
import com.turkcell.libraryapp.mapper.BookMapper;
import com.turkcell.libraryapp.repository.AuthorRepository;
import com.turkcell.libraryapp.repository.BookRepository;
import com.turkcell.libraryapp.repository.CategoryRepository;
import com.turkcell.libraryapp.repository.PublisherRepository;
import com.turkcell.libraryapp.rules.BookBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@Validated
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;
    private final BookBusinessRules bookBusinessRules;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository, CategoryRepository categoryRepository, BookMapper bookMapper, BookBusinessRules bookBusinessRules) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
        this.bookMapper = bookMapper;
        this.bookBusinessRules = bookBusinessRules;
    }

    public BookResponse createBook(@Valid BookRequest bookRequest){

        Book book = bookMapper.bookRequestToBook(bookRequest);

        bookBusinessRules.validateBook(book);

        Category category = categoryRepository.findById(bookRequest.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found"));
        book.setCategory(category);

        Author author = authorRepository.findById(bookRequest.getAuthorId())
                .orElseThrow(()-> new NotFoundException("Author not found"));
        book.setAuthor(author);

        Publisher publisher = publisherRepository.findById(bookRequest.getPublisherId())
                .orElseThrow(()-> new NotFoundException("Publisher not found"));
        book.setPublisher(publisher);

        Book bookSaved = this.bookRepository.save(book);

        return bookMapper.bookToBookResponse(bookSaved);
    }

    public List<BookResponse> getAllBooks(){
        List<Book> bookList =  bookRepository.findAll();
        return bookMapper.bookToBookResponseList(bookList);
    }

    public BookResponse getBookById(Integer id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new NotFoundException("Book not found"));
        return bookMapper.bookToBookResponse(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public List<BookResponse> findBookByLanguage(String language){
        List<Book> bookList = bookRepository.findByLanguage(language);
        return bookMapper.bookToBookResponseList(bookList);
    }

    public List<BookResponse> highValueOfStock(){
        List<Book> bookList = bookRepository.highValueOfStock();
        return bookMapper.bookToBookResponseList(bookList);
    }

    public BookResponse updateBookStock(Integer id, Integer delta){
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookBusinessRules.checkBookStatus(book);
        if(delta == 0)
        {
            throw new RuntimeException("No updated");
        }

        book.setTotalCopies(book.getTotalCopies() + delta);
        book.setAvailableCopies(book.getAvailableCopies() + delta);

        bookBusinessRules.checkAvailableCopies(book);
        bookRepository.save(book);

        return bookMapper.bookToBookResponse(book);
    }

}
