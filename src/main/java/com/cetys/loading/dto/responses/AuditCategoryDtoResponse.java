package com.cetys.loading.dto.responses;

import com.cetys.loading.enums.SCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditCategoryDtoResponse {

    private Long id;
    private Long auditId;
    private SCategory sCategory;
    private String name;
    private String description;
    private Long baseCategoryId;
}
