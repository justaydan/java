package com.lessons.repository;

import com.lessons.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntity, Long> {
}
