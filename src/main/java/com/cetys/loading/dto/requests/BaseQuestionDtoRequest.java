package com.cetys.loading.dto.requests;

import com.cetys.loading.dto.BaseCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseQuestionDtoRequest {

    private Long id;
    private BaseCategoryDto baseCategory;
    private String question;
}
