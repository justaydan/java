package com.lessons.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Money {

    private float amount;
    private String currency;
}
