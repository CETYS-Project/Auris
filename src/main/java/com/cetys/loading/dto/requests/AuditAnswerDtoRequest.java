package com.cetys.loading.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditAnswerDtoRequest {

    private Long auditQuestionId;
    private int score;
    private String notes;
    private String imageUrl;
}
