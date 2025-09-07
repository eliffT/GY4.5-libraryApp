package com.turkcell.libraryapp.dto.book;

import com.turkcell.libraryapp.entity.Category;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;

public class BookForAddDto {
    private String title;
    private Date year;
    private String language;
    private int stock;
    private Integer categoryId;

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
}
