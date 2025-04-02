package com.cetys.loading.dto.response;

import java.util.List;

public class AuditCategoryDtoResponse {
    private Long id;
    private String name;
    private String description;
    private List<AuditQuestionDtoResponse> auditQuestions;
}
