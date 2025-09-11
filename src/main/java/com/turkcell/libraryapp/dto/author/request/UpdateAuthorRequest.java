package com.turkcell.libraryapp.dto.author.request;

public class UpdateAuthorRequest {
    private String firstName;
    private String lastName;
    private Integer id;

    public UpdateAuthorRequest() {
    }

    public UpdateAuthorRequest(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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
}
