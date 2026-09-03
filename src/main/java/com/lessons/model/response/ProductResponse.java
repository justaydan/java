package com.lessons.model.response;

import com.lessons.entity.Money;
import com.lessons.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private Money price;
    private Money costPrice;

    public static ProductResponse from(ProductEntity entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCostPrice()
        );
    }
}
