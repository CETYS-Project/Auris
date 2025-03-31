package com.cetys.loading.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntityDto {

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntityDto(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseEntityDto() {
    }
}
