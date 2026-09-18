package com.lessons.controller.v2;

import com.lessons.model.request.OrderRequestDto;
import com.lessons.model.response.OrderResponseDtoV2;
import com.lessons.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("orderControllerV2")
@RequestMapping("/api/v2/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public OrderResponseDtoV2 create(@RequestBody @Valid OrderRequestDto request) {
        return orderService.toResponseDtoV2(orderService.createOrder(request));
    }
}
