package com.cetys.loading.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cetys.loading.dto.request.SubareaCreateDtoRequest;
import com.cetys.loading.dto.response.SubareaDtoResponse;
import com.cetys.loading.model.Subarea;

@Mapper(componentModel = "spring")
public interface SubareaMapper {
    SubareaDtoResponse toDto(Subarea subarea);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "area", ignore = true)
    @Mapping(target = "baseCategories", ignore = true)
    @Mapping(target = "audits", ignore = true)
    Subarea toEntity(SubareaCreateDtoRequest subareaCreateDtoRequest);
}
