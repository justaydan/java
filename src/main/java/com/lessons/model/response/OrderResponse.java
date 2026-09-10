package com.lessons.model.response;

import com.lessons.model.entity.CustomerEntity;
import com.lessons.model.entity.OrderEntity;
import com.lessons.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private OrderStatus status;
    private String name;
    private CustomerEntity customerEntity;


    public static OrderResponse from(OrderEntity entity) {
        return new OrderResponse(entity.getId(), entity.getStatus(), entity.getName(), entity.getCustomer());
    }
}
