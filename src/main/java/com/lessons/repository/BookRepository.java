package com.lessons.repository;

import com.lessons.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Page<BookEntity> findAll(Pageable pageable);
}
