package com.abdullah.BiblioBook.service.interfaces;

import com.abdullah.BiblioBook.dto.request.CreateBookRequest;
import com.abdullah.BiblioBook.dto.request.UpdateBookRequest;
import com.abdullah.BiblioBook.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookResponse createBook(CreateBookRequest request);

    BookResponse getBookById(Long id);

    Page<BookResponse> getAllBooks(Pageable pageable);

    BookResponse updateBook(Long id, UpdateBookRequest request);

    void deleteBook(Long id);

    Page<BookResponse> searchByTitle(String title, Pageable pageable);

    Page<BookResponse> filterByAuthor(String author, Pageable pageable);

    Page<BookResponse> filterByCategory(String category, Pageable pageable);
}
