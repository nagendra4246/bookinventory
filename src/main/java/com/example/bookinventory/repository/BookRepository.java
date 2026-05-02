package com.example.bookinventory.repository;

import com.example.bookinventory.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Find by ISBN
    Optional<Book> findByIsbn(String isbn);

    // Find all books by author (case-insensitive)
    List<Book> findByAuthorIgnoreCase(String author);
}