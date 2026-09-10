package com.lessons.service;

import com.lessons.model.entity.ProductEntity;
import com.lessons.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ProductEntity> getById(Long id) {
        return repository.findById(id);
    }

    public ProductEntity update(Long id, ProductEntity productEntity) {
        ProductEntity existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
        existing.setName(productEntity.getName());
        existing.setPrice(productEntity.getPrice());
        existing.setCostPrice(productEntity.getCostPrice());
        return repository.save(existing);
    }
}
