package com.turkcell.libraryapp.dto.publisher;

public class PublisherForAddDto {
    private Integer id;

    private String name;

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

    public PublisherForAddDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublisherForAddDto() {
    }
}
