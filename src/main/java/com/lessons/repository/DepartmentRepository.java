package com.lessons.repository;

import com.lessons.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

//    List<DepartmentEntity> findByEmployeesName(String name);

//    @Query("SELECT d FROM DepartmentEntity d")
//    List<DepartmentEntity> findAllNPlusOne();

//    @EntityGraph(attributePaths = "employees")
//    @Override
//    List<DepartmentEntity> findAll();
}
