package com.lessons.repository;

import com.lessons.entity.EmployeeEntity;
import com.lessons.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
