package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.author.request.CreateAuthorRequest;
import com.turkcell.libraryapp.dto.author.response.CreatedAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetAllAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetByIdAuthorResponse;
import com.turkcell.libraryapp.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<GetAllAuthorResponse> getAllWithDto(){
        return authorService.getAllWithDto();
    }
    @PostMapping()
    public CreatedAuthorResponse createAuthorWithDto(@RequestBody CreateAuthorRequest createAuthorRequest){
        return authorService.createAuthorWithDto(createAuthorRequest);
    }
    @GetMapping("/{id}")
    public GetByIdAuthorResponse getByIdAuthorResponse(@PathVariable Integer id){
        return authorService.getByIdAuthorResponse(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthorWithById(@PathVariable Integer id){
        authorService.deleteAuthorWithById(id);
    }
}
