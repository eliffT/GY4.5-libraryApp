package com.turkcell.libraryapp.dto.user.response;


import com.turkcell.libraryapp.entity.BookReservation;
import com.turkcell.libraryapp.entity.Loan;

import java.util.List;

public class UserResponse {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private List<BookReservation> bookReservations;
    private List<Loan> loans;

    public UserResponse() {
    }

    public UserResponse(Integer id, String name, String lastName, String email, String phone, List<BookReservation> bookReservations, List<Loan> loans) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.bookReservations = bookReservations;
        this.loans = loans;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<BookReservation> getBookReservations() {
        return bookReservations;
    }

    public void setBookReservations(List<BookReservation> bookReservations) {
        this.bookReservations = bookReservations;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
