package com.lessons.repository;

import com.lessons.entity.InvoiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    Page<InvoiceEntity> findAll(Pageable pageable);
}
