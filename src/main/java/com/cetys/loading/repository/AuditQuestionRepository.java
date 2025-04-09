package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.projection.AuditQuestionProjection;

public interface AuditQuestionRepository extends JpaRepository<AuditQuestion, Long> {
    @Query("SELECT aq, ac.id as auditCategoryId FROM AuditQuestion aq " +
            "JOIN aq.auditCategory ac " +
            "WHERE ac.id IN :auditCategoryIds")
    List<AuditQuestionProjection> findByAuditCategoryIdIn(@Param("auditCategoryIds") List<Long> auditCategoryIds);

}
