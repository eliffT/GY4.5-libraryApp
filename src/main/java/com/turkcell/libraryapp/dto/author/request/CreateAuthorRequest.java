package com.turkcell.libraryapp.dto.author.request;

import com.turkcell.libraryapp.entity.Book;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CreateAuthorRequest {

    @Size(min = 2,max = 25)
    private String firstName;
    @Size(min = 2,max = 25)
    private String lastName;

    public CreateAuthorRequest() {
    }

    public CreateAuthorRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
