package com.example.bookinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDTO {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int quantity;
    private LocalDateTime createdAt;
}