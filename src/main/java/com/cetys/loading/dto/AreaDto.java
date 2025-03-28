package com.cetys.loading.dto;

import com.cetys.loading.model.Area;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AreaDto {
    private String name;
    private Long orgId;

    public AreaDto(Area area) {
        this.name = area.getName();
        this.orgId = area.getOrg().getId();
    }
}
