package com.cetys.loading.repository;

import com.cetys.loading.model.AuditCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditCategoryRepository extends JpaRepository<AuditCategory, Long> {
}
