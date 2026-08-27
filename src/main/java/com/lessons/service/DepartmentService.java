package com.lessons.service;

import com.lessons.entity.DepartmentEntity;
import com.lessons.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity save(DepartmentEntity department) {
        return departmentRepository.save(department);
    }

    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    @Transactional
    public void printWithNPlusOne() {
        List<DepartmentEntity> departments = departmentRepository.findAllNPlusOne();
        departments.forEach(d -> {
            System.out.println("Department: " + d.getName());
            d.getEmployees().forEach(e ->
                    System.out.println("  Employee: " + e.getName())
            );
        });
    }

    public void printWithGraphEntity() {
        departmentRepository.findAll().forEach(d -> {
            System.out.println("Department: " + d.getName());
            d.getEmployees().forEach(e ->
                    System.out.println("  Employee: " + e.getName())
            );
        });
    }

    public List<DepartmentEntity> findByEmployeeName(String name) {
        return departmentRepository.findByEmployeesName(name);
    }
}
