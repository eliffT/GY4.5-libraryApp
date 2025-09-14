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

    public List<GetAllAuthorResponse> getAllWithDto(){
        List<Author> authorList = authorRepository.findAll();
        List<GetAllAuthorResponse> authorResponseList = new ArrayList<GetAllAuthorResponse>();

        for(Author author: authorList){
            GetAllAuthorResponse authorResponse = new GetAllAuthorResponse();
            authorResponse.setId(author.getId());
            authorResponse.setFirstName(author.getFirstName());
            authorResponse.setLastName(author.getLastName());
            //authorResponse.setBooks(null);

            authorResponseList.add(authorResponse);
        }
        return authorResponseList;
    }

    public CreatedAuthorResponse createAuthorWithDto(@Valid CreateAuthorRequest createAuthorRequest){

        AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
        Author author = INSTANCE.createAuthorRequestToAuthor(createAuthorRequest);
        this.authorRepository.save(author);
        return INSTANCE.authorToCreatedAuthorResponse(author);

    }

    public GetByIdAuthorResponse getByIdAuthorResponse(Integer id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Bu id ile bir yazar bulunamadı."));

        GetByIdAuthorResponse getByIdAuthorResponse = new GetByIdAuthorResponse();
        getByIdAuthorResponse.setFirstName(author.getFirstName());
        getByIdAuthorResponse.setLastName(author.getLastName());

        return getByIdAuthorResponse;
    }

    public void deleteAuthorWithById(Integer id){
        authorRepository.deleteById(id);
    }
}
