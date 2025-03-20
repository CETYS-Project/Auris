package com.cetys.loading.service;

import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.repository.AuditCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditCategoryService {

    @Autowired
    private AuditCategoryRepository auditCategoryRepository;

    public List<AuditCategory> getAllAuditCategories() {
        return auditCategoryRepository.findAll();
    }

    public AuditCategory getAuditCategoryById(Long id) {
        Optional<AuditCategory> auditCategory = auditCategoryRepository.findById(id);
        return auditCategory.orElse(null);
    }

    public AuditCategory createAuditCategory(AuditCategory auditCategory) {
        return auditCategoryRepository.save(auditCategory);
    }

    public AuditCategory updateAuditCategory(Long id, AuditCategory auditCategoryDetails) {
        Optional<AuditCategory> auditCategoryOptional = auditCategoryRepository.findById(id);
        if (auditCategoryOptional.isPresent()) {
            AuditCategory auditCategory = auditCategoryOptional.get();
            auditCategory.setSubarea(auditCategoryDetails.getSubarea());
            auditCategory.setSCategory(auditCategoryDetails.getSCategory());
            auditCategory.setName(auditCategoryDetails.getName());
            auditCategory.setDescription(auditCategoryDetails.getDescription());
            auditCategory.setBaseCategory(auditCategoryDetails.getBaseCategory());
            return auditCategoryRepository.save(auditCategory);
        } else {
            return null;
        }
    }

    public void deleteAuditCategory(Long id) {
        auditCategoryRepository.deleteById(id);
    }
}