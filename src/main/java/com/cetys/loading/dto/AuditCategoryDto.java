package com.cetys.loading.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditCategoryDto {
    Long id;
    SCategory sCategory;
    String name;
    String description;
    List<AuditQuestionsDto> questions;

    public AuditCategoryDto(AuditCategory auditCategory, List<AuditQuestion> auditQuestions) {
        this.id = auditCategory.getId();
        this.sCategory = auditCategory.getSCategory();
        this.name = auditCategory.getName();
        this.description = auditCategory.getDescription();
        this.questions = auditQuestions.stream().map(AuditQuestionsDto::new).collect(Collectors.toList());
    }
}
