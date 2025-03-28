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

import com.cetys.loading.dto.SubareaDto;
import com.cetys.loading.model.Area;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.service.SubareaService;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/subarea")
public class SubareaController {
    @Autowired
    SubareaService subareaService;

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/")
    public ResponseEntity<SubareaDto> createSubarea(@RequestBody SubareaDto subareaDto) {
        Subarea subarea = new Subarea();
        subarea.setName(subareaDto.getName());

        Area area = entityManager.getReference(Area.class, subareaDto.getAreaId());
        subarea.setArea(area);

        Subarea createdSubarea = subareaService.createSubarea(subarea);
        SubareaDto createdSubareaDto = new SubareaDto(createdSubarea);
        return ResponseEntity.status(201).body(createdSubareaDto);
    }

    @GetMapping("/{areaId}")
    public ResponseEntity<List<SubareaDto>> getAllSubareasByAreaId(@PathVariable("areaId") Long areaId) {
        List<Subarea> subareas = subareaService.getAllSubareasByAreaId(areaId);
        return ResponseEntity.ok(subareas.stream().map(SubareaDto::new).collect(Collectors.toList()));
    }

}
