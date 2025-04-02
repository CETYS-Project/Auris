package com.cetys.loading.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaCreateDtoRequest {
    @NotBlank(message = "El nombre de la área es requerido")
    private String name;
}
