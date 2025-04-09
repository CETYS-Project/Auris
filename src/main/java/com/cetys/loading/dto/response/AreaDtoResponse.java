package com.cetys.loading.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaDtoResponse {
    private Long id;
    private String name;
    private String description;
    private String logoUrl;
}
