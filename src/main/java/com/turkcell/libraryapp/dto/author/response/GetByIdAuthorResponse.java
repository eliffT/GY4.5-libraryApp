package com.turkcell.libraryapp.dto.author.response;

import com.turkcell.libraryapp.dto.book.response.BookResponse;

import java.util.List;

public class GetByIdAuthorResponse {
    private String firstName;
    private String lastName;
    private List<BookResponse> books;


    public GetByIdAuthorResponse() {
    }

    public GetByIdAuthorResponse(List<BookResponse> books, String lastName, String firstName) {
        this.books = books;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }
}
