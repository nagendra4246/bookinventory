package com.example.bookinventory.service;

import com.example.bookinventory.dto.BookRequestDTO;
import com.example.bookinventory.dto.BookResponseDTO;
import com.example.bookinventory.entity.Book;
import com.example.bookinventory.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public BookResponseDTO createBook(BookRequestDTO request) {

        // Duplicate ISBN check
        repository.findByIsbn(request.getIsbn())
                .ifPresent(b -> {
                    throw new RuntimeException("ISBN already exists");
                });

        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();

        Book saved = repository.save(book);

        return mapToResponse(saved);
    }

    @Override
    public Page<BookResponseDTO> getAllBooks(Pageable pageable) {
        Page<Book> page = repository.findAll(pageable);

        return new PageImpl<>(
                page.getContent()
                        .stream()
                        .map(this::mapToResponse)
                        .collect(Collectors.toList()),
                pageable,
                page.getTotalElements()
        );
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return mapToResponse(book);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO request) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (request.getTitle() != null) book.setTitle(request.getTitle());
        if (request.getAuthor() != null) book.setAuthor(request.getAuthor());
        if (request.getPrice() > 0) book.setPrice(request.getPrice());
        if (request.getQuantity() >= 0) book.setQuantity(request.getQuantity());

        Book updated = repository.save(book);

        return mapToResponse(updated);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        repository.delete(book);
    }

    private BookResponseDTO mapToResponse(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .quantity(book.getQuantity())
                .createdAt(book.getCreatedAt())
                .build();
    }
}