package com.cetys.loading.dto;

import com.cetys.loading.model.BaseQuestion;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseQuestionDto extends BaseEntityDto {

    private Long id;
    private BaseCategoryDto baseCategory;
    private String question;

    public BaseQuestionDto() {
    }

    public BaseQuestionDto(Long id, BaseCategoryDto baseCategory, String question) {
        this.id = id;
        this.baseCategory = baseCategory;
        this.question = question;
    }
}
