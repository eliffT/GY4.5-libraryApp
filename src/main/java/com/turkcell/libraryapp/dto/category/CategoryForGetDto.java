package com.turkcell.libraryapp.dto.category;

import com.turkcell.libraryapp.entity.Book;
import jakarta.persistence.OneToMany;

import java.util.List;

public class CategoryForGetDto {

    private String category;

    public CategoryForGetDto(String category) {
        this.category = category;
    }

    public CategoryForGetDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
