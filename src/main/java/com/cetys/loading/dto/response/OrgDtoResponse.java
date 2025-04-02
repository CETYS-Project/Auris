package com.cetys.loading.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrgDtoResponse {
    private Long id;
    private String name;
}
