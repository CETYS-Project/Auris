package com.cetys.loading.dto.requests;

import com.cetys.loading.dto.AuditCategoryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuditInfoDtoRequest {

    Long id;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<AuditCategoryDto> categories;
}
