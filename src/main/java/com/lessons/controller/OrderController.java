package com.lessons.controller;

import com.lessons.enums.OrderStatus;
import com.lessons.model.request.OrderForUpdateRequest;
import com.lessons.model.request.OrderRequest;
import com.lessons.model.response.OrderResponse;
import com.lessons.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return orderService
                .getById(id)
                .map(OrderResponse::from)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

    }

    @GetMapping(value = "/customer/{customerId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomer(@PathVariable Long customerId) {
        List<OrderResponse> list = orderService
                .getOrdersByCustomer(customerId)
                .stream()
                .map(OrderResponse::from)
                .toList();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> get(@RequestParam(required = false) OrderStatus status) {
        List<OrderResponse> list = orderService
                .getByStatus(status)
                .stream()
                .map(OrderResponse::from)
                .toList();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/{id}")
    public OrderResponse update(@PathVariable Long id, @RequestBody @Valid OrderRequest request) {
        return OrderResponse.from(orderService.update(id, request));
    }

    @PatchMapping("/{id}")
    public OrderResponse patch(@PathVariable Long id, @RequestBody @Valid OrderForUpdateRequest request) {
        return OrderResponse.from(orderService.updateStatus(id, request.getStatus()));
    }
}
