package com.abdullah.BiblioBook.service.impl;


import com.abdullah.BiblioBook.dto.request.CreateBookRequest;
import com.abdullah.BiblioBook.dto.request.UpdateBookRequest;
import com.abdullah.BiblioBook.dto.response.BookResponse;
import com.abdullah.BiblioBook.entity.Book;
import com.abdullah.BiblioBook.exception.ResourceNotFoundException;
import com.abdullah.BiblioBook.exception.DuplicateResourceException;
import com.abdullah.BiblioBook.mapper.BookMapper;
import com.abdullah.BiblioBook.repository.BookRepository;
import com.abdullah.BiblioBook.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse createBook(CreateBookRequest request) {

        if (bookRepository.existsByIsbn(request.getIsbn())) {
            throw new DuplicateResourceException("Book with this ISBN already exists");
        }

        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);

        return bookMapper.toResponse(savedBook);
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));

        return bookMapper.toResponse(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toResponse);
    }

    @Override
    public BookResponse updateBook(Long id, UpdateBookRequest request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));

        bookMapper.updateBookFromDto(request, existingBook);

        Book updatedBook = bookRepository.save(existingBook);

        return bookMapper.toResponse(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));

        bookRepository.delete(existingBook);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> searchByTitle(String title, Pageable pageable) {
        return bookRepository.findByTitleContainingIgnoreCase(title, pageable)
                .map(bookMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> filterByAuthor(String author, Pageable pageable) {
        return bookRepository.findByAuthorContainingIgnoreCase(author, pageable)
                .map(bookMapper::toResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> filterByCategory(String category, Pageable pageable) {
        return bookRepository.findByCategoryContainingIgnoreCase(category, pageable)
                .map(bookMapper::toResponse);
    }
}
