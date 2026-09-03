package com.lessons.controller;

import com.lessons.model.response.ProductResponse;
import com.lessons.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id)
                .map(ProductResponse::from)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.findAll().stream()
                .map(ProductResponse::from)
                .toList();
    }
}
