package com.lessons.service;

import com.lessons.entity.Book;
import com.lessons.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByPublishedYearGreaterThanAndAvailableTrue(Integer year) {
        return bookRepository.findByPublishedYearGreaterThanAndAvailableTrue(year);
    }

    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public Boolean existsByTitle(String title) {
        return bookRepository.existsByTitle(title);
    }

    @Transactional
    public void deleteByAuthor(String author) {
        bookRepository.deleteByAuthor(author);
    }
}
