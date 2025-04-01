package com.cetys.loading.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditQuestionDtoResponse {

    private Long id;
    private Long auditCategoryId;
    private Long baseQuestionId;
    private String question;
}
