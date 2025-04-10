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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/audit")
@Tag(name = "Audit Management", description = "APIs for managing audits and audit answers")
public class AuditController {

    private final AuditService auditService;

    @Operation(summary = "Create a new audit for a subarea", description = "Creates a new audit record for the specified subarea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Audit created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid subarea ID"),
            @ApiResponse(responseCode = "404", description = "Subarea not found")
    })
    @PostMapping("/subarea/{subareaId}")
    public ResponseEntity<Void> createAudit(
            @Parameter(description = "ID of the subarea to create audit for", required = true) @Valid @PathVariable("subareaId") Long subareaId) {
        auditService.createAudit(subareaId);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Get audits by subarea ID", description = "Retrieves all audits associated with a specific subarea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved audits"),
            @ApiResponse(responseCode = "404", description = "Subarea not found")
    })
    @GetMapping("/subarea/{subareaId}")
    public ResponseEntity<List<AuditDtoResponse>> getAuditsBySubareaId(
            @Parameter(description = "ID of the subarea to retrieve audits for", required = true) @PathVariable("subareaId") Long subareaId) {
        return ResponseEntity.ok(auditService.getAuditsBySubareaId(subareaId));
    }

    @Operation(summary = "Answer a single audit question", description = "Submits an answer for a specific audit question")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Answer submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid answer data"),
            @ApiResponse(responseCode = "404", description = "Question not found")
    })
    @PostMapping("/answer")
    public ResponseEntity<Void> answerQuestion(
            @Parameter(description = "Answer data for the question", required = true) @Valid @RequestBody AnswerDtoRequest answerDtoRequest) {
        auditService.answerQuestion(answerDtoRequest.getQuestionId(), answerDtoRequest);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Answer multiple audit questions", description = "Submits answers for multiple audit questions in a single batch")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Answers submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid answer data"),
            @ApiResponse(responseCode = "404", description = "One or more questions not found")
    })
    @PostMapping("/answer/batch")
    public ResponseEntity<Void> answerQuestions(
            @Parameter(description = "List of answers for multiple questions", required = true) @Valid @RequestBody List<AnswerDtoRequest> answerDtoRequests) {
        auditService.answerQuestions(answerDtoRequests);
        return ResponseEntity.status(201).build();
    }
}
