package com.cetys.loading.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cetys.loading.dto.request.OrgCreateDtoRequest;
import com.cetys.loading.dto.response.OrgDtoResponse;
import com.cetys.loading.model.Org;

@Mapper(componentModel = "spring")
public interface OrgMapper {

    OrgDtoResponse toDto(Org org);

    Org toEntity(OrgDtoResponse orgDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "areas", ignore = true)
    Org toEntity(OrgCreateDtoRequest orgCreateDtoRequest);

}
