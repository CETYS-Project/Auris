package com.cetys.loading.dto;

import com.cetys.loading.model.Audit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditResponseDto {
    private Long id;

    public AuditResponseDto(Audit audit) {
        this.id = audit.getId();
    }
}
