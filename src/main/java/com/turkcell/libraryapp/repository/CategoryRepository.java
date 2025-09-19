package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Optional<Category> findTop1ByCategoryNameIgnoreCase(String categoryName);

}
