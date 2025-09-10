package com.turkcell.libraryapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Book> Books;

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public Integer getId() {
        return id;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
