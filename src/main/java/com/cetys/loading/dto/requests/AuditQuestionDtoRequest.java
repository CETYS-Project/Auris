package com.cetys.loading.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditQuestionDtoRequest {

    private Long id;
    private Long auditCategoryId;
    private Long baseQuestionId;
    private String question;
}
