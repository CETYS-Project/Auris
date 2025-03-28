package com.cetys.loading.dto;

import com.cetys.loading.enums.SCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditCategoryResponse {
    SCategory sCategory;
    String name;
    String description;
}
