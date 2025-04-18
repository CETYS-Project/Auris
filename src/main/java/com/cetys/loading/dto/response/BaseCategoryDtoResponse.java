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
public class BaseCategoryDtoResponse {
    private Long id;
    private String name;
    private String description;
    private List<BaseQuestionDtoResponse> baseQuestions;
}
