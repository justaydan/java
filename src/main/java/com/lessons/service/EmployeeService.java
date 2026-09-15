package com.lessons.service;

import com.lessons.exception.NotFoundException;
import com.lessons.model.entity.ContactInfo;
import com.lessons.model.entity.DepartmentEntity;
import com.lessons.model.entity.EmployeeEntity;
import com.lessons.enums.EmploymentType;
import com.lessons.model.request.EmployeePatchDto;
import com.lessons.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public EmployeeEntity patch(Long id, EmployeePatchDto dto) {
        EmployeeEntity entity = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found: " + id));

        Optional.ofNullable(dto.getName()).ifPresent(entity::setName);
        Optional.ofNullable(dto.getSalary()).ifPresent(entity::setSalary);
        Optional.ofNullable(dto.getDepartmentId()).ifPresent(deptId ->
                entity.setDepartment(new DepartmentEntity(deptId, null)));
        Optional.ofNullable(dto.getEmail()).ifPresent(email -> {
            ContactInfo contactInfo = entity.getContactInfo() != null
                    ? entity.getContactInfo()
                    : new ContactInfo();
            contactInfo.setEmail(email);
            entity.setContactInfo(contactInfo);
        });

        return entity;
    }
}
