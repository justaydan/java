package com.lessons.model.request;

import com.lessons.enums.OrderStatus;
import com.lessons.model.entity.CustomerEntity;
import com.lessons.model.entity.DepartmentEntity;
import com.lessons.model.entity.EmployeeEntity;
import com.lessons.model.entity.OrderEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {

    @NotNull
    private OrderStatus status;

    @NotNull
    private String name;

    @NotNull
    private Long customerId;

    public OrderEntity toEntity() {
        CustomerEntity customer = new CustomerEntity(customerId, null);
        return new OrderEntity(null, status, name, customer);
    }
}
