package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.projection.AuditQuestionProjection;

public interface AuditQuestionRepository extends JpaRepository<AuditQuestion, Long> {
    @Query("SELECT aq.id as id, aq.question as question, ac.id as auditCategoryId, aa as auditAnswer " +
            "FROM AuditQuestion aq " +
            "JOIN aq.auditCategory ac " +
            "LEFT JOIN aq.auditAnswer aa " +
            "WHERE ac.id IN :auditCategoryIds")
    List<AuditQuestionProjection> findByAuditCategoryIdIn(@Param("auditCategoryIds") List<Long> auditCategoryIds);

}
