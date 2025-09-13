package com.turkcell.libraryapp.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class BookForAddDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String title;
    @NotNull
    private Date year;
    @NotNull
    private String language;
    @Positive
    private int stock;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer authorId;
    @NotNull
    private Integer publisherId;

    public BookForAddDto(String title, Date year, String language, int stock, Integer categoryId) {
        this.title = title;
        this.year = year;
        this.language = language;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    public BookForAddDto() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
}
