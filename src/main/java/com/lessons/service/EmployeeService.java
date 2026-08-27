package com.lessons.service;

import com.lessons.entity.EmployeeEntity;
import com.lessons.repository.EmployeeRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public void save(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> findByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    public List<EmployeeEntity> findBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
}
