package com.abdullah.BiblioBook.dto.response;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private BigDecimal price;
    private Integer stockQuantity;
    private LocalDate publishedDate;
}
