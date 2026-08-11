package com.lessons.service;

import com.lessons.entity.Product;
import com.lessons.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return this.repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}
