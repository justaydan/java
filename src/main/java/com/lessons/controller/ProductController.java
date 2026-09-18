package com.lessons.controller;

import com.lessons.exception.ProductNotFoundException;
import com.lessons.model.request.ProductUpdateDto;
import com.lessons.model.response.v1.ProductResponse;
import com.lessons.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController("productControllerV1")
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id)
                .map(ProductResponse::from)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.findAll().stream()
                .map(ProductResponse::from)
                .toList();
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestBody @Valid ProductUpdateDto request) {
        return ProductResponse.from(productService.update(id, request));
    }
}
