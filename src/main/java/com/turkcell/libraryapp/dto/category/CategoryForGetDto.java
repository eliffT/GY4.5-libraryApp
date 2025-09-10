package com.turkcell.libraryapp.dto.category;

import com.turkcell.libraryapp.entity.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CategoryForGetDto {

    private String categoryName;

    public CategoryForGetDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryForGetDto() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
