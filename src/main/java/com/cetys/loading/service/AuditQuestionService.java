package com.cetys.loading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.repository.AuditQuestionRepository;

@Service
public class AuditQuestionService {

    @Autowired
    private AuditQuestionRepository auditQuestionRepository;

    public List<AuditQuestion> getAuditQuestionsByAuditCategory(Long auditCategoryId) {
        return auditQuestionRepository.findAllByAuditCategoryId(auditCategoryId);
    }
}
