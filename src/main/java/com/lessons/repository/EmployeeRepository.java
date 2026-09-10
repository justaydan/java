package com.lessons.repository;

import com.lessons.model.entity.EmployeeEntity;
import com.lessons.enums.EmploymentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //    List<EmployeeEntity> findByDepartmentName(String departmentName);
    List<EmployeeEntity> findBySalaryGreaterThan(Double salary);

    @EntityGraph(attributePaths = "department")
    List<EmployeeEntity> findByDepartmentName(String department);

    @Transactional
    EmployeeEntity save(EmployeeEntity employeeEntity);

    Page<EmployeeEntity> findByType(EmploymentType type, Pageable pageable);
}
