package com.cetys.loading.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrgCreateDtoRequest {
    @NotBlank(message = "El nombre de la organización es requerido")
    private String name;
}
