package com.turkcell.libraryapp.dto.user.response;


import com.turkcell.libraryapp.entity.BookReservation;
import com.turkcell.libraryapp.entity.Loan;
import com.turkcell.libraryapp.entity.enumarations.Role;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private Boolean active;
    private LocalDateTime createdAt;
    private List<BookReservation> bookReservations;
    private List<Loan> loans;

    public UserResponse() {
    }

    public UserResponse(Integer id, String firstName, String lastName, String email, String phone, List<BookReservation> bookReservations, List<Loan> loans) {
        this.id = id;
        this.firstName= firstName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
