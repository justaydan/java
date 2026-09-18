package com.lessons.service;

import com.lessons.enums.CustomerStatus;
import com.lessons.exception.*;
import com.lessons.model.entity.*;
import com.lessons.enums.OrderStatus;
import com.lessons.model.request.OrderRequestDto;
import com.lessons.model.response.OrderItemResponseDto;
import com.lessons.model.response.OrderResponseDto;
import com.lessons.model.response.OrderResponseDtoV2;
import com.lessons.repository.CustomerRepository;
import com.lessons.repository.OrderRepository;
import com.lessons.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderService {

    private EmployeeService employeeService;
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

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
                .orElseThrow(() -> new OrderNotFoundException("Order not found: " + id));

        if (!order.getStatus().canTransitionTo(newStatus) && order.getStatus() != newStatus) {
            throw new InvalidStatusTransitionException("Cannot transition from " + order.getStatus() + " to " + newStatus);
        }

        order.setStatus(newStatus);
        return order;
    }

    // --- Create order ---

    @Transactional
    public OrderEntity createOrder(OrderRequestDto dto) {
        CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found: " + dto.getCustomerId()));

        if (customer.getStatus() == CustomerStatus.BLOCKED)
            throw new CustomerBlockedException("Customer is blocked");

        ProductEntity product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new NotFoundException("Product not found: " + dto.getProductId()));

        OrderEntity order = new OrderEntity(null, OrderStatus.NEW, null, customer, null, LocalDateTime.now());
        order = orderRepository.save(order);

        OrderItemEntity item = new OrderItemEntity(null, order, product, dto.getQuantity());
        order.setItems(List.of(item));

        return orderRepository.save(order);
    }

    // --- Conversion methods ---

    public OrderResponseDto toResponseDto(OrderEntity order) {
        float totalAmount = order.getItems() == null ? 0 :
                order.getItems().stream()
                        .map(i -> i.getProduct().getPrice().getAmount() * i.getQuantity())
                        .reduce(0f, Float::sum);

        return new OrderResponseDto(order.getId(), totalAmount, order.getStatus(), order.getCreatedAt());
    }

    public OrderResponseDtoV2 toResponseDtoV2(OrderEntity order) {
        float totalAmount = order.getItems() == null ? 0 :
                order.getItems().stream()
                        .map(i -> i.getProduct().getPrice().getAmount() * i.getQuantity())
                        .reduce(0f, Float::sum);

        List<OrderItemResponseDto> items = order.getItems() == null ? List.of() :
                order.getItems().stream().map(OrderItemResponseDto::from).toList();

        return new OrderResponseDtoV2(order.getId(), totalAmount, order.getStatus(), order.getCreatedAt(), items);
    }
}
