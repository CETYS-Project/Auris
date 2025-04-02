package com.cetys.loading.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.AuditDto;
import com.cetys.loading.dto.request.AuditCreateDtoRequest;
import com.cetys.loading.service.AuditService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/audit")
@RequiredArgsConstructor
public class AuditController {

    private final AuditService auditService;

    @PostMapping("/subarea/{subareaId}")
    public ResponseEntity<AuditDto> createAudit(
            @PathVariable("subareaId") Long subareaId,
            @RequestBody AuditCreateDtoRequest auditCreateDtoRequest) {
        return ResponseEntity.ok(auditService.createAudit(subareaId, auditCreateDtoRequest));
    }
}
