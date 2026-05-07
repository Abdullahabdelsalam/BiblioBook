package com.abdullah.BiblioBook.repository;

import com.abdullah.BiblioBook.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // validation/business checks
    boolean existsByIsbn(String isbn);

    // search by title
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // filter by author
    Page<Book> findByAuthorContainingIgnoreCase(String author, Pageable pageable);

    // filter by category
    Page<Book> findByCategoryContainingIgnoreCase(String category, Pageable pageable);
}