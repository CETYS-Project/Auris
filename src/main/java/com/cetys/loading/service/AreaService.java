package com.cetys.loading.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cetys.loading.dto.request.AreaCreateDtoRequest;
import com.cetys.loading.dto.response.AreaDtoResponse;
import com.cetys.loading.mapper.AreaMapper;
import com.cetys.loading.model.Area;
import com.cetys.loading.model.Org;
import com.cetys.loading.repository.AreaRepository;
import com.cetys.loading.repository.OrgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;
    private final OrgRepository orgRepository;
    private final AreaMapper areaMapper;

    public AreaDtoResponse createArea(Long orgId, AreaCreateDtoRequest areaCreateDtoRequest) {
        Org org = orgRepository.findById(orgId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organización no encontrada"));
        Area area = areaMapper.toEntity(areaCreateDtoRequest);

        org.addArea(area);
        area = areaRepository.save(area);

        return areaMapper.toDto(area);
    }

    public List<AreaDtoResponse> getAreas(Long orgId) {
        Org org = orgRepository.findById(orgId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organización no encontrada"));
        return org.getAreas().stream().map(areaMapper::toDto).collect(Collectors.toList());
    }
}
