package com.turkcell.libraryapp.dto.category;

public class CategoryForAddDto {
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
