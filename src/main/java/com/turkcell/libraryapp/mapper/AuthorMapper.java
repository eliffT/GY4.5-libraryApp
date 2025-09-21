package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.author.request.CreateAuthorRequest;
import com.turkcell.libraryapp.dto.author.response.CreatedAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetAllAuthorResponse;
import com.turkcell.libraryapp.dto.author.response.GetByIdAuthorResponse;
import com.turkcell.libraryapp.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author createAuthorRequestToAuthor(CreateAuthorRequest createAuthorRequest);

    GetByIdAuthorResponse authorToGetByIdAuthorResponse(Author author);

    CreatedAuthorResponse  authorToCreatedAuthorResponse(Author author);

    List<GetAllAuthorResponse> authorToAuthorResponseList(List<Author> authorList);

}
