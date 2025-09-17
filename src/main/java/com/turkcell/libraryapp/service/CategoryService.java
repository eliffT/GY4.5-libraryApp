package com.turkcell.libraryapp.service;

import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.mapper.CategoryMapper;
import com.turkcell.libraryapp.repository.CategoryRepository;
import com.turkcell.libraryapp.rules.CategoryBusinessRules;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryBusinessRules categoryBusinessRules,
                           CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryBusinessRules = categoryBusinessRules;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryForGetDto> getAllWithDto() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    public CategoryForGetDto addWithDto(@Valid CategoryForAddDto categoryForAddDto){

        categoryBusinessRules.categoryShouldNotExistWithSameName(categoryForAddDto.getCategoryName());

        Category category = categoryMapper.toEntity(categoryForAddDto);
        Category saved = categoryRepository.save(category);

        return categoryMapper.toDto(saved);

    }

    public CategoryForGetDto getByIdWithDto(Integer id)
    {
        Category category = categoryRepository.findById(id).orElseThrow();
        return categoryMapper.toDto(category);
    }

    public void deleteCategoryWithById(Integer id)
    {
        categoryRepository.deleteById(id);
    }
}
