package com.turkcell.libraryapp.dto.category;

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
