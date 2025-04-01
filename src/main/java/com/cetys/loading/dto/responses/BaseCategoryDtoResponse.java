package com.cetys.loading.dto.responses;

import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.Subarea;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseCategoryDtoResponse {

    private Long id;
    private Subarea subarea;
    private SCategory sCategory;
    private String name;
    private String description;
}
