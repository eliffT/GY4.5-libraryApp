package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.category.request.CategoryRequest;
import com.turkcell.libraryapp.dto.category.response.CategoryResponse;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.mapper.CategoryMapper;
import com.turkcell.libraryapp.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,  CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.categoryToCategoryResponseList(categoryList);
    }

    public CategoryResponse createCategory(@Valid CategoryRequest categoryRequest){
        Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
        Category categorySaved = this.categoryRepository.save(category);
        return categoryMapper.categoryToCategoryResponse(categorySaved);
    }

    public CategoryResponse getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return categoryMapper.categoryToCategoryResponse(category);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
