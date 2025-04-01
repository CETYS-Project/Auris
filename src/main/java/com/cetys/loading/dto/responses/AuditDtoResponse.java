package com.cetys.loading.dto.responses;

import com.cetys.loading.model.Audit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuditDtoResponse {
    private Long id;

    public AuditDtoResponse(Audit audit) {
        this.id = audit.getId();
    }
}
