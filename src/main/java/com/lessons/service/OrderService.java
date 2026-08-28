package com.lessons.service;

import com.lessons.entity.EmployeeEntity;
import com.lessons.entity.OrderEntity;
import com.lessons.exception.OrderAlreadyCancelledException;
import com.lessons.exception.StockUpdateException;
import com.lessons.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private EmployeeService employeeService;
    private OrderRepository orderRepository;

    public OrderService(EmployeeService service, OrderRepository repository) {
        orderRepository = repository;
        employeeService = service;
    }


    public void save(OrderEntity entity) {
        orderRepository.save(entity);
    }

}
