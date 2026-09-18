package com.lessons.controller.v1;

import com.lessons.model.request.OrderRequestDto;
import com.lessons.model.response.OrderResponseDto;
import com.lessons.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("orderControllerV1")
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public OrderResponseDto create(@RequestBody @Valid OrderRequestDto request) {
        return orderService.toResponseDto(orderService.createOrder(request));
    }
}
