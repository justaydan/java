package com.lessons.model.response;

import com.lessons.model.entity.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemResponseDto {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Float unitPrice;

    public static OrderItemResponseDto from(OrderItemEntity item) {
        return new OrderItemResponseDto(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getQuantity(),
                item.getProduct().getPrice().getAmount()
        );
    }
}
