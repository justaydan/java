package com.lessons.service;

import com.lessons.exception.NotFoundException;
import com.lessons.exception.OrderNotFoundException;
import com.lessons.exception.OrderStatusTransitionException;
import com.lessons.model.entity.CustomerEntity;
import com.lessons.model.entity.OrderEntity;
import com.lessons.model.entity.OrderItemEntity;
import com.lessons.model.entity.ProductEntity;
import com.lessons.enums.OrderStatus;
import com.lessons.model.request.OrderItemDto;
import com.lessons.model.request.OrderRequest;
import com.lessons.repository.CustomerRepository;
import com.lessons.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private EmployeeService employeeService;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;


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

    @Transactional
    public OrderEntity updateStatus(Long id, OrderStatus newStatus) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found: " + id));

        if (!order.getStatus().canTransitionTo(newStatus) && order.getStatus() != newStatus) {
            throw new OrderStatusTransitionException("Cannot transition from " + order.getStatus() + " to " + newStatus);
        }

        order.setStatus(newStatus);
        return order;
    }

    @Transactional
    public OrderEntity update(Long id, OrderRequest request) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + id));

        CustomerEntity customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found: " + request.getCustomerId()));

        List<OrderItemEntity> newItems = request.getItems().stream()
                .map(dto -> new OrderItemEntity(null, order, new ProductEntity(dto.getProductId(), null, null, null, null), dto.getQuantity()))
                .toList();

        order.setCustomer(customer);
        order.setStatus(request.getStatus());
        order.setName(request.getName());
        order.getItems().clear();
        order.getItems().addAll(newItems);

        return order;
    }


}
