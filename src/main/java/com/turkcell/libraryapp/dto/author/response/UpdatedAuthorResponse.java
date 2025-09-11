package com.turkcell.libraryapp.dto.author.response;

public class UpdatedAuthorResponse {
    private String firstName;
    private String lastName;

    public UpdatedAuthorResponse() {
    }

    public UpdatedAuthorResponse(String firstName, String lastName) {
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
