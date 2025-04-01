package com.cetys.loading.dto.responses;

import com.cetys.loading.model.AuditQuestion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditAnswerDtoResponse {

    private Long id;
    private AuditQuestion auditQuestion;
    private int score;
    private String notes;
    private String imageUrl;
}
