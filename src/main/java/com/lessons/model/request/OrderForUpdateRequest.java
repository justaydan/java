package com.lessons.model.request;

import com.lessons.enums.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderForUpdateRequest {

    @NotNull
    private OrderStatus status;
}
