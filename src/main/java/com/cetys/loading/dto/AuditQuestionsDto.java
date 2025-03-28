package com.cetys.loading.dto;

import com.cetys.loading.model.AuditQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditQuestionsDto {
    Long id;
    String question;

    public AuditQuestionsDto(AuditQuestion auditQuestion) {
        this.id = auditQuestion.getId();
        this.question = auditQuestion.getQuestion();
    }
}