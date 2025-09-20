package com.turkcell.libraryapp.dto.book.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

public class BookRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String title;

    @NotNull
    private LocalDate year;
    @NotNull
    private String language;
    @Min(0)
    private int totalCopies;
    @Positive
    private int availableCopies;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer authorId;
    @NotNull
    private Integer publisherId;

    public BookRequest(String title, LocalDate year, String language, int totalCopies,
                       int availableCopies, Integer categoryId, Integer authorId, Integer publisherId) {
        this.title = title;

        this.year = year;
        this.language = language;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    public BookRequest() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
