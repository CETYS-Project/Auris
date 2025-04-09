package com.cetys.loading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.AuditAnswer;

public interface AuditAnswerRepository extends JpaRepository<AuditAnswer, Long> {
}
