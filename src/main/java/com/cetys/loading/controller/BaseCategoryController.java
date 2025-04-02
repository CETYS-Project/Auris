package com.cetys.loading.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.response.BaseCategoryDtoResponse;
import com.cetys.loading.service.BaseCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/base")
public class BaseCategoryController {

    private final BaseCategoryService baseCategoryService;

    @GetMapping("/{subareaId}")
    public ResponseEntity<List<BaseCategoryDtoResponse>> getAllBaseCategories(
            @PathVariable("subareaId") Long subareaId) {
        return ResponseEntity.ok(baseCategoryService.getAllBaseCategories(subareaId));
    }
}
