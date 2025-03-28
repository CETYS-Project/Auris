package com.cetys.loading.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.AuditDto;
import com.cetys.loading.dto.AuditInfoDto;
import com.cetys.loading.dto.AuditResponseDto;
import com.cetys.loading.model.Audit;
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
    public ResponseEntity<AuditResponseDto> createAudit(@RequestBody AuditDto auditDto) {
        Audit audit = new Audit();
        audit.setSubarea(entityManager.getReference(Subarea.class, auditDto.getSubareaId()));
        Audit createdAudit = auditService.createAudit(audit);
        return ResponseEntity.status(201).body(new AuditResponseDto(createdAudit));
    }

    @GetMapping("/{subareaId}")
    public ResponseEntity<List<AuditResponseDto>> getAuditsBySubarea(@PathVariable("subareaId") Long subareaId) {
        return ResponseEntity.ok(auditService.getAuditsBySubarea(subareaId).stream().map(AuditResponseDto::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/categories/{auditId}")
    public ResponseEntity<AuditInfoDto> getAuditCategoriesByAudit(@PathVariable("auditId") Long auditId) {
        return ResponseEntity.ok(auditService.getAuditInfo(auditId));
    }

    @GetMapping("/categories/{auditId}/{auditCategoryId}/questions")
    public List<AuditQuestion> getAuditQuestionsByAuditCategory(@PathVariable("auditId") Long auditId,
            @PathVariable("auditCategoryId") Long auditCategoryId) {
        return auditQuestionService.getAuditQuestionsByAuditCategory(auditCategoryId);
    }

}
