package com.cetys.loading.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cetys.loading.dto.request.AuditCreateDtoRequest;
import com.cetys.loading.model.Audit;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subarea", ignore = true)
    @Mapping(target = "auditCategories", ignore = true)
    Audit toEntity(AuditCreateDtoRequest auditCreateDtoRequest);

}
