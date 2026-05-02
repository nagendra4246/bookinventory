package com.example.bookinventory.service;
import com.example.bookinventory.dto.BookRequestDTO;
import com.example.bookinventory.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookResponseDTO createBook(BookRequestDTO request);

    Page<BookResponseDTO> getAllBooks(Pageable pageable);

    BookResponseDTO getBookById(Long id);

    BookResponseDTO updateBook(Long id, BookRequestDTO request);

    void deleteBook(Long id);
}
