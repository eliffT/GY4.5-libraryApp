package com.turkcell.libraryapp.dto.author.response;

import com.turkcell.libraryapp.entity.Book;

import java.util.List;

public class GetAllAuthorResponse {
    private String firstName;
    private String lastName;
    private Integer id;
    private List<Book> books;

    public GetAllAuthorResponse() {
    }

    public GetAllAuthorResponse(String firstName, String lastName, Integer id, List<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.books = books;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
