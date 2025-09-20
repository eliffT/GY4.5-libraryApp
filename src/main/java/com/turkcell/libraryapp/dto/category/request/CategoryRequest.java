package com.turkcell.libraryapp.dto.category.request;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    private String categoryName;

    public CategoryRequest() {
    }

    public CategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
