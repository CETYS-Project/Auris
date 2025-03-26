package com.cetys.loading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.AuditDto;
import com.cetys.loading.model.Audit;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.service.AuditCategoryService;
import com.cetys.loading.service.AuditQuestionService;
import com.cetys.loading.service.AuditService;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/audit")
public class AuditController {
    @Autowired
    AuditService auditService;

    @Autowired
    AuditCategoryService auditCategoryService;

    @Autowired
    AuditQuestionService auditQuestionService;

    @Autowired
    EntityManager entityManager;

    @PostMapping("/")
    public Audit createAudit(@RequestBody AuditDto auditDto) {
        Audit audit = new Audit();
        audit.setSubarea(entityManager.getReference(Subarea.class, auditDto.getSubareaId()));
        return auditService.createAudit(audit);
    }

    @GetMapping("/{id}")
    public Audit getAudit(@PathVariable Long id) {
        return auditService.getAuditById(id);
    }

    @GetMapping("/")
    public List<Audit> getAuditsBySubarea(@RequestParam Long subareaId) {
        return auditService.getAuditsBySubarea(subareaId);
    }

    @GetMapping("/categories/{auditId}")
    public List<AuditCategory> getAuditCategoriesByAudit(@PathVariable Long auditId) {
        return auditCategoryService.getAuditCategoriesByAudit(auditId);
    }

    @GetMapping("/categories/{auditId}/{auditCategoryId}/questions")
    public List<AuditQuestion> getAuditQuestionsByAuditCategory(@PathVariable Long auditId,
            @PathVariable Long auditCategoryId) {
        return auditQuestionService.getAuditQuestionsByAuditCategory(auditCategoryId);
    }

}
