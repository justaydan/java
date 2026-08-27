package com.lessons.service;

import com.lessons.entity.AuthorEntity;
import com.lessons.entity.BookEntity;
import com.lessons.repository.AuthorRepository;
import com.lessons.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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


    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public Page<BookEntity> findAll(int page, int size, String sortBy) {
        return bookRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}
