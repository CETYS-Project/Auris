package com.cetys.loading.dto;

import com.cetys.loading.model.AuditQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditAnswerDto {

    private Long id;
    private AuditQuestion auditQuestion;
    private int score;
    private String notes;
    private String imageUrl;

    public AuditAnswerDto() {}

    public AuditAnswerDto(Long id, AuditQuestion auditQuestion, int score, String notes, String imageUrl) {
        this.id = id;
        this.auditQuestion = auditQuestion;
        this.score = score;
        this.notes = notes;
        this.imageUrl = imageUrl;
    }
}
