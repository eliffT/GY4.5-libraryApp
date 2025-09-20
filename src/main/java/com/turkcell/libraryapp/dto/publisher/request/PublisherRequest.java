package com.turkcell.libraryapp.dto.publisher.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PublisherRequest {

    @NotBlank
    private String name;

    public PublisherRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
