package com.lessons.service;

import com.lessons.entity.InvoiceEntity;
import com.lessons.exception.OrderAlreadyCancelledException;
import com.lessons.repository.InvoiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

    private LogService log;
    private InvoiceRepository invoiceRepository;

    InvoiceService(LogService logService, InvoiceRepository repository) {
        log = logService;
        invoiceRepository = repository;
    }

    @Transactional(rollbackFor = OrderAlreadyCancelledException.class)
    public void generateInvoice() {
        log.writeLog();
        throw new OrderAlreadyCancelledException(1L);
    }

    public Page<InvoiceEntity> get(int page, int size) {
        return invoiceRepository.findAll(PageRequest.of(page, size, Sort.by("date").descending()));
    }
}
