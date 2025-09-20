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

    public UserResponse() {
    }

    public UserResponse(Integer id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
