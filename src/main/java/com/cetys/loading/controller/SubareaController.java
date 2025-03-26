package com.cetys.loading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostAuthorize("/")
    public Subarea createSubarea(@RequestBody SubareaDto subareaDto) {
        Subarea subarea = new Subarea();
        subarea.setName(subareaDto.getName());

        Area area = entityManager.getReference(Area.class, subareaDto.getAreaId());
        subarea.setArea(area);

        return subareaService.createSubarea(subarea);
    }

    @GetMapping("/")
    public List<Subarea> getAllSubareas() {
        return subareaService.getAllSubareas();
    }

}
