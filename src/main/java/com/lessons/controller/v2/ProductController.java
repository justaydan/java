package com.lessons.controller.v2;

import com.lessons.model.request.ProductUpdateDto;
import com.lessons.model.response.v2.ProductResponse;
import com.lessons.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController("productControllerV2")
@RequestMapping("/api/v2/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productService.getById(id)
                .map(ProductResponse::from)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }
}
