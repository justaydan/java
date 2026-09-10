package com.lessons.repository;

import com.lessons.model.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

//    List<DepartmentEntity> findByEmployeesName(String name);

//    @Query("SELECT d FROM DepartmentEntity d")
//    List<DepartmentEntity> findAllNPlusOne();

//    @EntityGraph(attributePaths = "employees")
//    @Override
//    List<DepartmentEntity> findAll();
}
