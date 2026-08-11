package com.lessons.repository;

import com.lessons.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByPublishedYearGreaterThanAndAvailableTrue(Integer publishedYear);
    List<Book> findByTitleContaining(String title);
    Boolean existsByTitle(String title);
    void deleteByAuthor(String author);
}
