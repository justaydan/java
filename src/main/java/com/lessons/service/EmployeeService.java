package com.lessons.service;

import com.lessons.entity.EmployeeEntity;
import com.lessons.enums.EmploymentType;
import com.lessons.repository.EmployeeRepository;
import jakarta.persistence.OrderBy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<EmployeeEntity> getByType(EmploymentType type) {
        return employeeRepository.findByType(type, PageRequest.of(0, 10, Sort.by("personName.firstName")));
    }
}
