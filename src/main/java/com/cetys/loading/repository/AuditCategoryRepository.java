package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.AuditCategory;

public interface AuditCategoryRepository extends JpaRepository<AuditCategory, Long> {
    List<AuditCategory> findAllByAuditId(Long auditId);
}
