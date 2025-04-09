package com.cetys.loading.dto.response;

import java.util.List;

import com.cetys.loading.enums.SCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditCategoryDtoResponse {
    private Long id;
    private String name;
    private String description;
    private SCategory sCategory;

    private List<AuditQuestionDtoResponse> auditQuestions;

    private Integer questionsAnswered;
    private Integer totalQuestions;
}
