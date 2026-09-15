package com.lessons.service;

import com.lessons.exception.NotFoundException;
import com.lessons.model.entity.ProductEntity;
import com.lessons.model.request.ProductUpdateDto;
import com.lessons.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ProductEntity update(Long id, ProductUpdateDto dto) {
        ProductEntity existing = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found: " + id));
        existing.setName(dto.getName());
        existing.setCategory(dto.getCategory());
        existing.setPrice(dto.getPrice());
        existing.setCostPrice(dto.getCostPrice());
        return existing;
    }
}
