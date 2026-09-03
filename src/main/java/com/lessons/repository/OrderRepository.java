package com.lessons.repository;

import com.lessons.entity.OrderEntity;
import com.lessons.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByCustomerId(Long id);
    List<OrderEntity> findByStatus(OrderStatus status);

}
