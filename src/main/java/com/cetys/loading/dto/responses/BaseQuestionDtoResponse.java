package com.cetys.loading.dto.responses;

import com.cetys.loading.dto.BaseCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseQuestionDtoResponse {

    private Long id;
    private BaseCategoryDto baseCategory;
    private String question;
}
