package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.author.request.CreateAuthorRequest;
import com.turkcell.libraryapp.dto.author.response.CreatedAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetAllAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetByIdAuthorResponse;
import com.turkcell.libraryapp.entity.Author;
import com.turkcell.libraryapp.mapper.AuthorMapper;
import com.turkcell.libraryapp.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.webjars.NotFoundException;

import java.util.*;

@Service
@Validated
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository,  AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<GetAllAuthorResponse> getAllAuthors(){
        List<Author> authorList = authorRepository.findAll();
        return authorMapper.authorToAuthorResponseList(authorList);
    }

    public CreatedAuthorResponse createAuthor(@Valid CreateAuthorRequest createAuthorRequest){
        AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
        Author author = INSTANCE.createAuthorRequestToAuthor(createAuthorRequest);
        this.authorRepository.save(author);
        return INSTANCE.authorToCreatedAuthorResponse(author);
    }

    public GetByIdAuthorResponse getAuthorById(Integer id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("No author found with this id."));
        return authorMapper.authorToGetByIdAuthorResponse(author);
    }

    public void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }
}
