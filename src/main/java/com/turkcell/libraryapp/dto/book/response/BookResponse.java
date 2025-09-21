package com.turkcell.libraryapp.dto.book.response;

import com.turkcell.libraryapp.dto.category.response.CategoryResponse;
import com.turkcell.libraryapp.dto.publisher.response.PublisherResponse;

import java.time.LocalDate;

public class BookResponse {
    private Integer id;
    private String isbn;
    private String title;
    private LocalDate year;
    private String language;
    private int availableCopies;
    private int totalCopies;
    private CategoryResponse category;
    private PublisherResponse publisher;

    public BookResponse(Integer id, String isbn, String title, LocalDate year, String language, int availableCopies,
                        int totalCopies, CategoryResponse category, PublisherResponse publisher) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.language = language;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.category = category;
        this.publisher = publisher;
    }

    public BookResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }

    public PublisherResponse getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherResponse publisher) {
        this.publisher = publisher;
    }
}
