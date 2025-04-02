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
}
