package com.turkcell.libraryapp.entity;

import com.turkcell.libraryapp.repository.CategoryRepository;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private Date year;
    private String language;
    private int stock;

    @ManyToOne()
    //@JoinColumn(name = "category_id", nullable = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "author_id")     // FK books tablosunda - owner side
    private Author author;

    @ManyToOne()
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
