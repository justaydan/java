package com.lessons.repository;

import com.lessons.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findByPriceLessThan(double price, Pageable pageable);

}
