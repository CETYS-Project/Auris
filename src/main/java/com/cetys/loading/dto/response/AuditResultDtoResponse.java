package com.cetys.loading.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditResultDtoResponse {
    private Long id;

    private List<AuditCategoryResultDtoResponse> auditCategoryResults;

    private Double totalScore;
    private Double totalMaxScore;
    private Double totalPercentage;
}
