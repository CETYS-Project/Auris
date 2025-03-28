package com.cetys.loading.dto;

import com.cetys.loading.model.Subarea;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubareaDto {
    private String name;
    private Long areaId;

    public SubareaDto(Subarea subarea) {
        this.name = subarea.getName();
        this.areaId = subarea.getArea().getId();
    }
}
