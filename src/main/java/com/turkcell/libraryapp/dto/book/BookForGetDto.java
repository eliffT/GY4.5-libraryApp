package com.turkcell.libraryapp.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.entity.Category;

import java.util.Date;

public class BookForGetDto {
    private String title;
    private Date year;
    private String language;
    private int stock;
    private CategoryForGetDto categoryForGetDto;

    public BookForGetDto(CategoryForGetDto categoryForGetDto, int stock, String language, Date year, String title) {
        this.categoryForGetDto = categoryForGetDto;
        this.stock = stock;
        this.language = language;
        this.year = year;
        this.title = title;
    }

    public BookForGetDto() {
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

    public CategoryForGetDto getCategoryForGetDto() {
        return categoryForGetDto;
    }

    public void setCategoryForGetDto(CategoryForGetDto categoryForGetDto) {
        this.categoryForGetDto = categoryForGetDto;
    }
}
