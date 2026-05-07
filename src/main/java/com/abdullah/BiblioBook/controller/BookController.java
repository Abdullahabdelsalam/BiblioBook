package com.abdullah.BiblioBook.controller;

import com.abdullah.BiblioBook.dto.request.CreateBookRequest;
import com.abdullah.BiblioBook.dto.request.UpdateBookRequest;
import com.abdullah.BiblioBook.dto.response.BookResponse;
import com.abdullah.BiblioBook.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookResponse createBook(@RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public Page<BookResponse> getAllBooks(Pageable pageable) {
        return bookService.getAllBooks(pageable);
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(
            @PathVariable Long id,
            @RequestBody UpdateBookRequest request) {
        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public Page<BookResponse> searchByTitle(
            @RequestParam String title,
            Pageable pageable) {
        return bookService.searchByTitle(title, pageable);
    }

    @GetMapping("/filter/author")
    public Page<BookResponse> filterByAuthor(
            @RequestParam String author,
            Pageable pageable) {
        return bookService.filterByAuthor(author, pageable);
    }

    @GetMapping("/filter/category")
    public Page<BookResponse> filterByCategory(
            @RequestParam String category,
            Pageable pageable) {
        return bookService.filterByCategory(category, pageable);
    }
}