package com.cetys.loading.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BaseEntityDtoRequest {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
