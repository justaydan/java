package com.lessons.service;

import com.lessons.entity.EmployeeEntity;
import com.lessons.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Transactional
    public void save(EmployeeEntity employeeEntity) {

        employeeRepository.save(employeeEntity);
    }

    @Transactional()
    public List<EmployeeEntity> getEmployee() {
        return employeeRepository.findAll();
    }
}
