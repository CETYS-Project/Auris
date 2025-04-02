package com.cetys.loading.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cetys.loading.dto.request.AreaCreateDtoRequest;
import com.cetys.loading.dto.response.AreaDtoResponse;
import com.cetys.loading.model.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaDtoResponse toDto(Area area);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "org", ignore = true)
    @Mapping(target = "subareas", ignore = true)
    Area toEntity(AreaCreateDtoRequest areaCreateDtoRequest);

}
