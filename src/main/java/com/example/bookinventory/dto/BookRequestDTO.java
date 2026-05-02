package com.example.bookinventory.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDTO {

    @NotBlank(message = "Title should not be blank")
    private String title;

    @NotBlank(message = "Author should not be blank")
    private String author;

    @NotBlank(message = "ISBN should not be blank")
    private String isbn;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Quantity cannot be negative")
    private int quantity;
}