package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.author.request.CreateAuthorRequest;
import com.turkcell.libraryapp.dto.author.response.CreatedAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetAllAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetByIdAuthorResponse;
import com.turkcell.libraryapp.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<GetAllAuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping()
    public CreatedAuthorResponse createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest){
        return authorService.createAuthor(createAuthorRequest);
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getAuthorById(@PathVariable Integer id){
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
    }
}
