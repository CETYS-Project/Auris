package com.cetys.loading.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditDtoResponse {
    private Long id;

    private List<AuditCategoryDtoResponse> auditCategories;

    private Integer questionsAnswered;
    private Integer totalQuestions;
}
