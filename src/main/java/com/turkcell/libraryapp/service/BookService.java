package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.book.BookForAddDto;
import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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

            CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
            categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
            bookForGetDto.setCategoryForGetDto(categoryForGetDto);

            bookForGetDtoList.add(bookForGetDto);
        }
        return bookForGetDtoList;
    }

    public BookForGetDto addWithDto(BookForAddDto bookForAddDto){
        Book book = new Book();
        book.setTitle(bookForAddDto.getTitle());
        book.setLanguage(bookForAddDto.getLanguage());
        book.setYear(bookForAddDto.getYear());
        book.setStock(bookForAddDto.getStock());

        Category category = new Category();
        category.setId(bookForAddDto.getCategoryId());

        book.setCategory(category);

        Book bookSaved = this.bookRepository.save(book);

        BookForGetDto bookForGetDto = new BookForGetDto();
        bookForGetDto.setTitle(bookSaved.getTitle());
        bookForGetDto.setLanguage(bookSaved.getLanguage());
        bookForGetDto.setYear(bookSaved.getYear());
        bookForGetDto.setStock(bookSaved.getStock());

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

        CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
        categoryForGetDto.setCategoryName(book.getCategory().getCategoryName());
        dto.setCategoryForGetDto(categoryForGetDto);
        return dto;
    }


}
