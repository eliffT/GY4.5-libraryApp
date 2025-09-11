package com.turkcell.libraryapp.dto.author.response;

import com.turkcell.libraryapp.entity.Book;

import java.util.List;

public class GetByIdAuthorResponse {
    private String firstName;
    private String lastName;
    private List<Book> books;


    public GetByIdAuthorResponse() {
    }

    public GetByIdAuthorResponse(List<Book> books, String lastName, String firstName) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
