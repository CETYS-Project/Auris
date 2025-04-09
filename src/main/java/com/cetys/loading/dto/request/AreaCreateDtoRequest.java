package com.cetys.loading.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaCreateDtoRequest {
    @NotBlank(message = "El nombre de la área es requerido")
    private String name;

    @NotBlank(message = "La descripción de la área es requerida")
    private String description;

    @NotBlank(message = "La URL del logo de la área es requerida")
    private String logoUrl;
}
