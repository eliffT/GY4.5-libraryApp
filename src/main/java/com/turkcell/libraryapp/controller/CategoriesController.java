package com.turkcell.libraryapp.controller;

import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoriesController {
    private CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryForGetDto> getAllWithDto() {
        return categoryService.getAllWithDto();
    }

   @PostMapping()
    public CategoryForGetDto addCategoryWithDto(@RequestBody CategoryForAddDto categoryForAddDto){
        return categoryService.addWithDto(categoryForAddDto);
    }
    @GetMapping("/{id}")
    public CategoryForGetDto getByIdWithDto(@PathVariable Integer id){
        return categoryService.getByIdWithDto(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryWithById(@PathVariable Integer id){
        categoryService.deleteCategoryWithById(id);
    }
}
