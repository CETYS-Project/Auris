package com.cetys.loading.controller;

import com.cetys.loading.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cetys.loading.model.Area;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    @GetMapping("/")
    public Object[] getAllAreas() {
        return areaRepository.findAll().toArray();
    }

}
