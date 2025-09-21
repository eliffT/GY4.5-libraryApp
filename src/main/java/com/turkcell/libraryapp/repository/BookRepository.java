package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
    List<Book> findByLanguage(String language);

    @Query(value = "select * from books order by stock desc limit 1",nativeQuery = true)
    List<Book> highValueOfStock();

    Optional<Book> findByTitleIgnoreCaseAndLanguageIgnoreCase(String title, String language);
}
