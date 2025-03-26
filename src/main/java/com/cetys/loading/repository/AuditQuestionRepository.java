package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.AuditQuestion;

public interface AuditQuestionRepository extends JpaRepository<AuditQuestion, Long> {
    List<AuditQuestion> findAllByAuditCategoryId(Long auditCategoryId);
}
