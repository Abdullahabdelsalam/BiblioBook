package com.abdullah.BiblioBook.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBookRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private String category;

    @Positive
    private BigDecimal price;

    @Min(0)
    private Integer stockQuantity;

    private LocalDate publishedDate;
}
