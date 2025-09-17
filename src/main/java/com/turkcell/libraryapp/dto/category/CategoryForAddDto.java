package com.turkcell.libraryapp.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryForAddDto {

    @NotBlank
    @Size(min = 3, max = 50)
    private String categoryName;

    public CategoryForAddDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryForAddDto() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
