package com.cetys.loading.controller;


import com.cetys.loading.model.AuditAnswer;
import com.cetys.loading.service.AuditAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit-answer")
public class AuditAnswerController {
    @Autowired
    AuditAnswerService auditAnswerService;

    @GetMapping("/")
    public List<AuditAnswer> getAllAuditAnswers() {
        return auditAnswerService.getAllAuditAnswers();
    }

    @GetMapping("/{id}")
    public AuditAnswer getAuditAnswerById(@PathVariable Long id) {
        return auditAnswerService.getAuditAnswerById(id);
    }

    @PostMapping("/")
    public AuditAnswer createAuditAnswer(@RequestBody AuditAnswer auditAnswer) {
        return auditAnswerService.createAuditAnswer(auditAnswer);
    }

    @PutMapping("/{id}")
    public AuditAnswer updateAuditAnswer(@PathVariable Long id, @RequestBody AuditAnswer auditAnswerDetails) {
        return auditAnswerService.updateAuditAnswer(id, auditAnswerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAuditAnswer(@PathVariable Long id) {
        auditAnswerService.deleteAuditAnswer(id);
    }
}
