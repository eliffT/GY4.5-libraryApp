package com.turkcell.libraryapp.repository;

import com.turkcell.libraryapp.entity.Author;
import com.turkcell.libraryapp.entity.Book;
import com.turkcell.libraryapp.entity.enumList.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
    List<Book> findByLanguage(String language);

    // ISBN'ye göre bir kitabın var olup olmadığını kontrol eden metod
    boolean existsByIsbn(String isbn);


    @Query("SELECT b FROM Book b WHERE " +
            "(:isbn = '' OR b.isbn LIKE %:isbn%) AND " +
            "(:title = '' OR b.title LIKE %:title%) AND " +
            "(:authorName = '' OR b.author.firstName LIKE %:authorName%) AND " +
            "(:status IS NULL OR b.status = :status)")
    List<Book> searchBooks(
            @Param("isbn") String isbn,
            @Param("title") String title,
            @Param("authorName") String authorName,
            @Param("status") BookStatus status
    );

    @Query(value = "select * from books order by stock desc limit 1",nativeQuery = true)
    List<Book> highValueOfStock();

    Optional<Book> findByTitleIgnoreCaseAndLanguageIgnoreCase(String title, String language);
}
