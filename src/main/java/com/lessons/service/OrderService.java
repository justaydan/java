package com.lessons.service;

import com.lessons.entity.EmployeeEntity;
import com.lessons.exception.OrderAlreadyCancelledException;
import com.lessons.exception.StockUpdateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private EmployeeService employeeService;

    public OrderService(EmployeeService service) {
        employeeService = service;
    }

    @Transactional(noRollbackFor = OrderAlreadyCancelledException.class, rollbackFor = StockUpdateException.class)
    public void cancelOrder() {
        employeeService.save(new EmployeeEntity(null, "test", 0.35));
        throw new StockUpdateException("message");
//        throw new OrderAlreadyCancelledException(3L);
    }
}
