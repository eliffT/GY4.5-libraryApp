package com.turkcell.libraryapp.mapper;

import com.turkcell.libraryapp.dto.category.CategoryForAddDto;
import com.turkcell.libraryapp.dto.category.CategoryForGetDto;
import com.turkcell.libraryapp.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toEntity(CategoryForAddDto dto);

    CategoryForGetDto toDto(Category category);

    List<CategoryForGetDto> toDtoList(List<Category> categories);

}
