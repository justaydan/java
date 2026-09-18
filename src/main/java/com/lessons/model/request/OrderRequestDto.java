package com.lessons.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequestDto {

    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(1)
    private Integer quantity;
}
