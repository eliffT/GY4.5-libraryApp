package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryForGetDto> getAllWithDto() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryForGetDto> categoryForGetDtoList = new ArrayList<CategoryForGetDto>();
        for(Category category: categoryList){
            CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
            categoryForGetDto.setCategoryName(category.getCategoryName());
            categoryForGetDtoList.add(categoryForGetDto);
        }
            return categoryForGetDtoList;
    }

    public CategoryForGetDto addWithDto(CategoryForAddDto categoryForAddDto){
        Category category = new Category();
        category.setCategoryName(categoryForAddDto.getCategoryName());

        Category categorySaved = this.categoryRepository.save(category);
        CategoryForGetDto categoryForGetDto = new CategoryForGetDto();
        categoryForGetDto.setCategoryName(categorySaved.getCategoryName());

        return categoryForGetDto;
    }
}
