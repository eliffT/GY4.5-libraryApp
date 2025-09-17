package com.turkcell.libraryapp.rules;

import com.turkcell.libraryapp.core.exception.type.BusinessException;
import com.turkcell.libraryapp.entity.Category;
import com.turkcell.libraryapp.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public void categoryShouldNotExistWithSameName(String name) {
        Category category = categoryRepository.findTop1ByCategoryNameIgnoreCase(name).orElse(null);
        if (category != null) {
            throw new RuntimeException("Category with name " + name + " already exists");
        }
    }
}
