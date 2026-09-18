package com.lessons.model.response.v1;

import com.lessons.model.entity.Money;
import com.lessons.model.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private Money price;

    public static ProductResponse from(ProductEntity entity) {
        return new ProductResponse(
                entity.getName(),
                entity.getPrice()
        );
    }
}
