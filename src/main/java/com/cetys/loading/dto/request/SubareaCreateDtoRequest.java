package com.cetys.loading.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubareaCreateDtoRequest {
    @NotBlank(message = "El nombre de la subárea es requerido")
    private String name;
}
