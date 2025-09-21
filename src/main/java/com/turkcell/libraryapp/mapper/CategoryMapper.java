package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.category.request.CategoryRequest;
import com.turkcell.libraryapp.dto.category.response.CategoryResponse;
import com.turkcell.libraryapp.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target="categoryId", source = "category.id")
    @Mapping(target="categoryName", source = "category.categoryName")
    CategoryResponse categoryToCategoryResponse(Category category);
    Category categoryRequestToCategory(CategoryRequest categoryRequest);
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target="categoryName", source = "category.categoryName")
    List<CategoryResponse> categoryToCategoryResponseList(List<Category> categoryList);

}
