package com.cetys.loading.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDtoRequest {
    private Long questionId;

    @NotNull(message = "La puntuación es requerida")
    @Min(value = -1, message = "La puntuación debe ser mayor o igual a 0")
    @Max(value = 5, message = "La puntuación debe ser menor o igual a 5")
    private int score;

    @NotNull(message = "Las notas son requeridas")
    @Size(max = 255, message = "Las notas deben tener menos de 255 caracteres")
    private String notes;

    private String imageUrl;
}
