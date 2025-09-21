package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.book.request.BookRequest;
import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse bookToBookResponse(Book book);
    @Mapping(target= "category.id", source = "categoryId")
    @Mapping(target = "author.id", source = "authorId")
    @Mapping(target = "publisher.id", source = "publisherId")
    Book bookRequestToBook(BookRequest request);
    List<BookResponse> bookToBookResponseList(List<Book> bookList);
}
