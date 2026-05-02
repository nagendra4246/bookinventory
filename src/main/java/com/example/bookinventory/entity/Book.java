package com.example.bookinventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Title should not be blank")
        private String title;

        @NotBlank(message = "Author should not be blank")
        private String author;

        @NotBlank(message = "ISBN should not be blank")
        @Column(unique = true)
        private String isbn;

        @Positive(message = "Price must be greater than 0")
        private double price;

        @Min(value = 0, message = "Quantity cannot be negative")
        private int quantity;

        private LocalDateTime createdAt;

        @PrePersist
        public void setCreatedAt() {
            this.createdAt = LocalDateTime.now();
        }
    }

