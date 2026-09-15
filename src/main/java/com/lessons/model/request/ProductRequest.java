package com.lessons.model.request;

import com.lessons.model.entity.Money;
import com.lessons.model.entity.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;

    @NotNull
    private String category;

    @NotNull
    private Money price;

    @NotNull
    private Money costPrice;

    @NotNull
    private Integer stock;

    public ProductEntity toEntity() {
        return new ProductEntity(null, name, price, costPrice, category, stock);
    }
}
