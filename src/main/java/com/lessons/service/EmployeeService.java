package com.lessons.service;

import com.lessons.entity.Employee;
import com.lessons.repository.EmployeeRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> findBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
}
