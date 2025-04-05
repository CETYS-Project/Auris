package com.cetys.loading.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditAnswerDtoResponse {
    private int score;
    private String notes;
    private String imageUrl;
}
