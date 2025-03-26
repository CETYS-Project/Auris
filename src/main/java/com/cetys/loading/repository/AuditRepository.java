package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    List<Audit> findAllBySubareaId(Long subareaId);
}
