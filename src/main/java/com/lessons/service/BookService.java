package com.lessons.service;

import com.lessons.entity.AuthorEntity;
import com.lessons.entity.BookEntity;
import com.lessons.repository.AuthorRepository;
import com.lessons.repository.BookRepository;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public AuthorEntity saveAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public void printBooksByAuthor(String name) {
        bookRepository.findByAuthorName(name).forEach(b ->
                        System.out.println("Book: " + b.getTitle()
//                        + ", Author: " + b.getAuthor().getName()
                        )
        );
    }

    public List<BookEntity> findByPublishedYearGreaterThanAndAvailableTrue(Integer year) {
        return bookRepository.findByPublishedYearGreaterThanAndAvailableTrue(year);
    }

    @Transactional
    public void findByTitleContaining(String title) {
        bookRepository.findByTitleContaining(title).forEach(b ->
                System.out.println("Book: " + b.getTitle()
                        + ", Author: "
                        + b.getAuthor().getName()
                )
        );
    }

    public Boolean existsByTitle(String title) {
        return bookRepository.existsByTitle(title);
    }

    public void deleteByAuthor(String name) {
        bookRepository.deleteByAuthorName(name);
    }
}
