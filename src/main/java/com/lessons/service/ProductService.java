package com.lessons.service;

import com.lessons.entity.ProductEntity;
import com.lessons.repository.ProductRepository;
import org.springframework.stereotype.Service;

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
}
