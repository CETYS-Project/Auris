package com.cetys.loading.mapper;

import org.mapstruct.Mapper;

import com.cetys.loading.dto.response.SubareaDtoResponse;
import com.cetys.loading.model.Subarea;

@Mapper(componentModel = "spring")
public interface SubareaMapper {
    SubareaDtoResponse toDto(Subarea subarea);
}
