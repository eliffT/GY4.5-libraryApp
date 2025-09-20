package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.book.request.BookRequest;
import com.turkcell.libraryapp.dto.book.response.BookResponse;
import com.turkcell.libraryapp.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses= {CategoryMapper.class, PublisherMapper.class})
public interface BookMapper {


    BookResponse bookToBookResponse(Book book);
    Book bookRequestToBook(BookRequest request);

    List<BookResponse> bookToBookResponseList(List<Book> bookList);
}
