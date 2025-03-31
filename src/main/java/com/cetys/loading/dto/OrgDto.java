package com.cetys.loading.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgDto {

    private Long id;
    private String name;

    public OrgDto() {}

    public OrgDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
