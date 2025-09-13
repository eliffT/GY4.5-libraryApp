package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.book.BookForAddDto;
import com.turkcell.libraryapp.dto.book.BookForGetDto;
import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {
    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookForGetDto> getAllWithDto(){
        return bookService.getAllWithDto();
    }
    @PostMapping()
    public BookForGetDto addBookWithDto(@Valid @RequestBody BookForAddDto bookForAddDto){
        return bookService.addWithDto(bookForAddDto);
    }
    @GetMapping("/{id}")
    public BookForGetDto getByIdWithDto(@PathVariable Integer id){
        return bookService.getByIdWithDto(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookWithById(@PathVariable Integer id){
              bookService.deleteBookWithById(id);
    }

    @GetMapping("/lang/{language}")
    public List<BookForGetDto> findByLanguage(@PathVariable String language){
        return bookService.findByLanguage(language);
    }
    @GetMapping("/highstock")
    public List<BookForGetDto> highValueOfStock(){
        return bookService.highValueOfStock();
    }


}
