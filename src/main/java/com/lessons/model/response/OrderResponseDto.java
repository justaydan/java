package com.lessons.model.response;

import com.lessons.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderResponseDto {

    private Long orderId;
    private Float totalAmount;
    private OrderStatus status;
    private LocalDateTime createdAt;
}
