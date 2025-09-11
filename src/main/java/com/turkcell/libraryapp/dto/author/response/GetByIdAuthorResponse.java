package com.turkcell.libraryapp.dto.author.response;

public class GetByIdAuthorResponse {
    private String firstName;
    private String lastName;

    public GetByIdAuthorResponse() {
    }

    public GetByIdAuthorResponse(String firstName, String lastName) {
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
