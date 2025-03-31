package com.cetys.loading.dto;

import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.BaseQuestion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditQuestionDto {

    private Long id;
    private Long auditCategoryId;
    private Long baseQuestionId;
    private String question;

    public AuditQuestionDto(Long id, Long auditCategoryId, Long baseQuestionId, String question) {
        this.id = id;
        this.auditCategoryId = auditCategoryId;
        this.baseQuestionId = baseQuestionId;
        this.question = question;
    }

    public static AuditQuestionDto fromAuditQuestion(AuditCategory auditCategory, BaseQuestion baseQuestion, String question) {
        AuditQuestionDto dto = new AuditQuestionDto();
        dto.setId(null);
        dto.setAuditCategoryId(auditCategory != null ? auditCategory.getId() : null);
        dto.setBaseQuestionId(baseQuestion != null ? baseQuestion.getId() : null);
        dto.setQuestion(question);
        return dto;
    }
}
