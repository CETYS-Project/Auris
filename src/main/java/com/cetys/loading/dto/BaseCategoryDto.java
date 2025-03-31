package com.cetys.loading.dto;

import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.Subarea;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCategoryDto {

    private Long id;
    private Subarea subarea;
    private SCategory sCategory;
    private String name;
    private String description;

    public BaseCategoryDto() {
    }

    public BaseCategoryDto(Long id, Subarea subarea, SCategory sCategory, String name, String description) {
        this.id = id;
        this.subarea = subarea;
        this.sCategory = sCategory;
        this.name = name;
        this.description = description;
    }

    public static BaseCategoryDto fromEntity(BaseCategory baseCategory) {
        BaseCategoryDto dto = new BaseCategoryDto();
        dto.setId(baseCategory.getId());
        dto.setSubarea(baseCategory.getSubarea());
        dto.setSCategory(baseCategory.getSCategory());
        dto.setName(baseCategory.getName());
        dto.setDescription(baseCategory.getDescription());
        return dto;
    }
}
