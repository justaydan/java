package com.lessons.service;

import com.lessons.entity.OrderEntity;
import com.lessons.enums.OrderStatus;
import com.lessons.exception.OrderAlreadyCancelledException;
import com.lessons.exception.StockUpdateException;
import com.lessons.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private EmployeeService employeeService;
    private OrderRepository orderRepository;


    public void save(OrderEntity entity) {
        orderRepository.save(entity);
    }

    public Optional<OrderEntity> getById(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderEntity> getOrdersByCustomer(Long id) {
        return orderRepository.findByCustomerId(id);
    }

    public List<OrderEntity> getByStatus(OrderStatus status) {
        if (status == null) {
            return orderRepository.findAll();
        }
        List<OrderEntity> result = orderRepository.findByStatus(status);
        return result.isEmpty() ? orderRepository.findAll() : result;
    }

}
