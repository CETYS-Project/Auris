package com.cetys.loading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.repository.AuditCategoryRepository;

@Service
public class AuditCategoryService {

    @Autowired
    private AuditCategoryRepository auditCategoryRepository;

    public List<AuditCategory> getAuditCategoriesByAudit(Long auditId) {
        return auditCategoryRepository.findAllByAuditId(auditId);
    }
}
