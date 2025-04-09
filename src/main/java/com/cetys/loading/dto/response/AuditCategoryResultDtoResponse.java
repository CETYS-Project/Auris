package com.cetys.loading.dto.response;

import com.cetys.loading.enums.SCategory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditCategoryResultDtoResponse {
    private Long id;

    private SCategory sCategory;
    private String name;
    private String description;

    private Double score;
    private Double maxScore;

    private Double percentage;

}
