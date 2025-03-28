package com.cetys.loading.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.AreaDto;
import com.cetys.loading.model.Area;
import com.cetys.loading.model.Org;
import com.cetys.loading.service.AreaService;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/{orgId}")
    public ResponseEntity<List<AreaDto>> getAreaListByOrgId(@PathVariable("orgId") Long orgId) {
        List<Area> areas = areaService.getAreaListByOrgId(orgId);
        return ResponseEntity.ok(areas.stream().map(AreaDto::new).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto areaDto) {
        Area area = new Area();
        area.setName(areaDto.getName());
        area.setOrg(entityManager.getReference(Org.class, areaDto.getOrgId()));

        Area createdArea = areaService.createArea(area);
        AreaDto createdAreaDto = new AreaDto(createdArea);
        return ResponseEntity.status(201).body(createdAreaDto);
    }
}
