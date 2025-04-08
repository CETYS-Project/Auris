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
public class OrgCreateDtoRequest {
    @NotBlank(message = "El nombre de la organización es requerido")
    private String name;

    @NotBlank(message = "La descripción de la organización es requerida")
    private String description;

    @NotBlank(message = "La paleta de colores de la organización es requerida")
    private String colorPalette;

    @NotBlank(message = "La URL del logo de la organización es requerida")
    private String logoUrl;
}
