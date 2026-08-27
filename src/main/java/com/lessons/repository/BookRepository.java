package com.lessons.repository;

import com.lessons.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    //    @EntityGraph(attributePaths = "author")
    List<BookEntity> findByAuthorName(String name);

    List<BookEntity> findByPublishedYearGreaterThanAndAvailableTrue(Integer publishedYear);

    //    @EntityGraph(attributePaths = "author")
//    @EntityGraph(attributePaths="author")
    @Transactional
    List<BookEntity> findByTitleContaining(String title);

    Boolean existsByTitle(String title);

    void deleteByAuthorName(String name);

}
