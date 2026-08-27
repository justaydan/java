package com.lessons.service;

import com.lessons.entity.LogEntity;
import com.lessons.repository.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class LogService {

    private LogRepository logRepository;

    LogService(LogRepository repository) {
        logRepository = repository;
    }

    @Transactional(propagation = REQUIRES_NEW)
    public void writeLog() {
        logRepository.save(new LogEntity(null, "test", LocalDate.now()));
    }
}
