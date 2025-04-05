package com.cetys.loading.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.request.AnswerDtoRequest;
import com.cetys.loading.dto.response.AuditDtoResponse;
import com.cetys.loading.service.AuditService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audit")
public class AuditController {

    private final AuditService auditService;

    @PostMapping("/subarea/{subareaId}")
    public ResponseEntity<Void> createAudit(
            @Valid @PathVariable("subareaId") Long subareaId) {
        auditService.createAudit(subareaId);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/subarea/{subareaId}")
    public ResponseEntity<List<AuditDtoResponse>> getAuditsBySubareaId(
            @PathVariable("subareaId") Long subareaId) {
        return ResponseEntity.ok(auditService.getAuditsBySubareaId(subareaId));
    }

    @PostMapping("/answer")
    public ResponseEntity<Void> answerQuestion(
            @Valid @RequestBody AnswerDtoRequest answerDtoRequest) {
        auditService.answerQuestion(answerDtoRequest.getQuestionId(), answerDtoRequest);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/answer/batch")
    public ResponseEntity<Void> answerQuestions(
            @Valid @RequestBody List<AnswerDtoRequest> answerDtoRequests) {
        auditService.answerQuestions(answerDtoRequests);
        return ResponseEntity.status(201).build();
    }
}
