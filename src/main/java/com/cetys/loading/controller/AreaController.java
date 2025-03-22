package com.cetys.loading.controller;

import com.cetys.loading.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cetys.loading.model.Area;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping
    public ResponseEntity<List<Area>> getAreaList() {
        List<Area> areas = areaService.getAreaList();
        return ResponseEntity.ok(areas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable Long id) {
        Area area = areaService.getAreaById(id);
        if (area != null) {
            return ResponseEntity.ok(area);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody Area area) {
        Area createdArea = areaService.createArea(area);
        return ResponseEntity.status(201).body(createdArea);
    }

    @PutMapping
    public ResponseEntity<Area> updateArea(@PathVariable Long id, @RequestBody Area areaDetails) {
        Area updatedArea = areaService.updateArea(id, areaDetails);
        return updatedArea != null ? ResponseEntity.ok(updatedArea)
                : ResponseEntity.notFound().build();
    }
}
