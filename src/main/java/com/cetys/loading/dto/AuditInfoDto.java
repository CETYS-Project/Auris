package com.cetys.loading.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cetys.loading.model.Audit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditInfoDto {
    Long id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    List<AuditCategoryDto> categories;

    public AuditInfoDto(Audit audit, List<AuditCategoryDto> categories) {
        this.id = audit.getId();
        this.createdAt = audit.getCreatedAt();
        this.updatedAt = audit.getUpdatedAt();
        this.categories = categories;
    }
}
