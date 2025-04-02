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
}
