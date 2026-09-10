package com.lessons.service;

import com.lessons.model.entity.EmployeeEntity;
import com.lessons.enums.EmploymentType;
import com.lessons.repository.EmployeeRepository;
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

    public List<EmployeeEntity> getByDepartment(String department) {
        return employeeRepository.findByDepartmentName(department);
    }

    @Transactional
    public EmployeeEntity update(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found: " + id));
        entity.setName(employeeEntity.getName());
        entity.setDepartment(employeeEntity.getDepartment());
        entity.setSalary(employeeEntity.getSalary());
        entity.setPersonName(employeeEntity.getPersonName());
        entity.setContactInfo(employeeEntity.getContactInfo());
        entity.setType(employeeEntity.getType());
        return employeeRepository.save(entity);
    }

    @Transactional
    public EmployeeEntity patch(Long id, EmployeeEntity employeeEntity) {
        EmployeeEntity entity = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found: " + id));
        if (employeeEntity.getName() != null) entity.setName(employeeEntity.getName());
        if (employeeEntity.getDepartment() != null) entity.setDepartment(employeeEntity.getDepartment());
        if (employeeEntity.getSalary() != null) entity.setSalary(employeeEntity.getSalary());
        if (employeeEntity.getPersonName() != null) entity.setPersonName(employeeEntity.getPersonName());
        if (employeeEntity.getContactInfo() != null) entity.setContactInfo(employeeEntity.getContactInfo());
        if (employeeEntity.getType() != null) entity.setType(employeeEntity.getType());
        return employeeRepository.save(entity);
    }
}
