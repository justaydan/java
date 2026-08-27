package com.lessons.service;

import com.lessons.entity.Notification;
import com.lessons.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository repository) {
        notificationRepository = repository;
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void sendDeletionAlert() {
        notificationRepository.save(new Notification(null, "test"));
    }
}
