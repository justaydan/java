package com.lessons.model.request;

import com.lessons.model.entity.Money;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductUpdateDto {

    @NotBlank
    private String name;

    @NotNull
    private String category;

    @NotNull
    private Money price;

    @NotNull
    private Money costPrice;
}
