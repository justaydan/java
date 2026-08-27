package com.lessons.service;

import com.lessons.entity.ProductEntity;
import com.lessons.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductEntity save(ProductEntity productEntity) {
        return this.repository.save(productEntity);
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Page<ProductEntity> findCheapProducts(double maxPrice, int page, int size) {
        return repository.findByPriceLessThan(maxPrice, PageRequest.of(page, size, Sort.by("price").ascending()));
    }
}
