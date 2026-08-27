package com.lessons.repository;

import com.lessons.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
//    List<EmployeeEntity> findByDepartmentName(String departmentName);
    List<EmployeeEntity> findBySalaryGreaterThan(Double salary);
}
