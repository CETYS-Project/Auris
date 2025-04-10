package com.cetys.loading.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.response.BaseCategoryDtoResponse;
import com.cetys.loading.service.BaseCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/base")
@Tag(name = "Base Category Management", description = "APIs for managing base categories")
public class BaseCategoryController {

    private final BaseCategoryService baseCategoryService;

    @Operation(summary = "Get base categories by subarea", description = "Retrieves all base categories associated with a specific subarea")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved base categories"),
            @ApiResponse(responseCode = "404", description = "Subarea not found")
    })
    @GetMapping("/{subareaId}")
    public ResponseEntity<List<BaseCategoryDtoResponse>> getAllBaseCategories(
            @Parameter(description = "ID of the subarea to retrieve base categories for", required = true) @PathVariable("subareaId") Long subareaId) {
        return ResponseEntity.ok(baseCategoryService.getAllBaseCategories(subareaId));
    }
}
