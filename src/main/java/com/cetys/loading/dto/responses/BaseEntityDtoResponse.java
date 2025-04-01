package com.cetys.loading.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BaseEntityDtoResponse {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
