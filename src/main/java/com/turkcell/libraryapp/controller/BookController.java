package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.book.request.BookRequest;
import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping()
    public BookResponse createBook(@Valid @RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }
    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Integer id){
        return bookService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
              bookService.deleteBook(id);
    }

    @GetMapping("/lang/{language}")
    public List<BookResponse> findBookByLanguage(@PathVariable String language){
        return bookService.findBookByLanguage(language);
    }

    @GetMapping("/highstock")
    public List<BookResponse> highValueOfStock(){
        return bookService.highValueOfStock();
    }

    @PutMapping("/{id}/copies")
    public BookResponse updateBookStock(@PathVariable Integer id, @RequestParam Integer delta){
        return bookService.updateBookStock(id, delta);
    }


}
