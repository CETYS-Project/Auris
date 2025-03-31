package com.cetys.loading.dto;

import com.cetys.loading.enums.SCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditCategoryDto {

    private Long id;
    private Long auditId;
    private SCategory sCategory;
    private String name;
    private String description;
    private Long baseCategoryId;

    public AuditCategoryDto(Long id, Long auditId, SCategory sCategory, String name, String description, Long baseCategoryId) {
        this.id = id;
        this.auditId = auditId;
        this.sCategory = sCategory;
        this.name = name;
        this.description = description;
        this.baseCategoryId = baseCategoryId;
    }
}
