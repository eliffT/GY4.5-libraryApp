package com.turkcell.libraryapp.dto.category;

public class CategoryForAddDto {
    private String category;

    public CategoryForAddDto(String category) {
        this.category = category;
    }

    public CategoryForAddDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
