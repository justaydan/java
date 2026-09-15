package com.lessons.model.request;

import com.lessons.enums.OrderStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotNull
    private OrderStatus status;

    @NotNull
    private String name;

    @NotNull
    private Long customerId;

    @NotEmpty
    private List<OrderItemDto> items;
}
