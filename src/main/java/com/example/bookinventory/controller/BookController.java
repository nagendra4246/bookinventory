package com.example.bookinventory.controller;

import com.example.bookinventory.dto.BookRequestDTO;
import com.example.bookinventory.dto.BookResponseDTO;
import com.example.bookinventory.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    // POST → Add new book
    @PostMapping
    public BookResponseDTO createBook(@Valid @RequestBody BookRequestDTO request) {
        return service.createBook(request);
    }

    // GET → All books (pagination)
    @GetMapping
    public Page<BookResponseDTO> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("id")));
        return service.getAllBooks(pageable);
    }

    // GET → Book by ID
    @GetMapping("/{id}")
    public BookResponseDTO getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    // PUT → Update book
    @PutMapping("/{id}")
    public BookResponseDTO updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequestDTO request
    ) {
        return service.updateBook(id, request);
    }

    // DELETE → Delete book
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}