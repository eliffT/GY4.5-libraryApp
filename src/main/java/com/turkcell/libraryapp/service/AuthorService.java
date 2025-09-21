package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.author.request.CreateAuthorRequest;
import com.turkcell.libraryapp.dto.author.response.CreatedAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetAllAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetByIdAuthorResponse;
import com.turkcell.libraryapp.entity.Author;
import com.turkcell.libraryapp.repository.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.webjars.NotFoundException;

import java.util.*;

@Service
@Validated
public class AuthorService {
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
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
        Author author = new Author();
        author.setFirstName(createAuthorRequest.getFirstName());
        author.setLastName(createAuthorRequest.getLastName());

        Author authorSaved = this.authorRepository.save(author);

        CreatedAuthorResponse createdAuthorResponse = new CreatedAuthorResponse();
        createdAuthorResponse.setId(authorSaved.getId());
        createdAuthorResponse.setFirstName(authorSaved.getFirstName());
        createdAuthorResponse.setLastName(authorSaved.getLastName());

        return createdAuthorResponse;
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
