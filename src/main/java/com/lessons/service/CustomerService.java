package com.lessons.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private NotificationService notificationService;

    public CustomerService(NotificationService service) {
        notificationService = service;
    }

    @Transactional
    public void deleteCustomer() {
        notificationService.sendDeletionAlert();
    }
}
