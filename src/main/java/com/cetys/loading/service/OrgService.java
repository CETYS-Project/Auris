package com.cetys.loading.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cetys.loading.dto.request.OrgCreateDtoRequest;
import com.cetys.loading.dto.response.OrgDtoResponse;
import com.cetys.loading.mapper.OrgMapper;
import com.cetys.loading.model.Org;
import com.cetys.loading.repository.OrgRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrgService {

    private final OrgRepository orgRepository;
    private final OrgMapper orgMapper;

    public List<OrgDtoResponse> getAllOrgs() {
        return orgRepository.findAll().stream()
                .map(orgMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrgDtoResponse createOrg(OrgCreateDtoRequest orgCreateDtoRequest) {
        Org org = orgMapper.toEntity(orgCreateDtoRequest);
        org = orgRepository.save(org);
        return orgMapper.toDto(org);
    }

}