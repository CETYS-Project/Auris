package com.cetys.loading.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetys.loading.dto.request.AreaCreateDtoRequest;
import com.cetys.loading.dto.request.OrgCreateDtoRequest;
import com.cetys.loading.dto.request.SubareaCreateDtoRequest;
import com.cetys.loading.dto.response.AreaDtoResponse;
import com.cetys.loading.dto.response.OrgDtoResponse;
import com.cetys.loading.dto.response.SubareaDtoResponse;
import com.cetys.loading.service.AreaService;
import com.cetys.loading.service.OrgService;
import com.cetys.loading.service.SubareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/org")
@RequiredArgsConstructor
@Tag(name = "Organization Management", description = "APIs for managing organizations, areas, and subareas")
public class OrgController {

    private final OrgService orgService;
    private final AreaService areaService;
    private final SubareaService subareaService;

    @Operation(summary = "Create a new organization", description = "Creates a new organization with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Organization created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid organization data")
    })
    @PostMapping("/")
    public ResponseEntity<OrgDtoResponse> createOrg(
            @Parameter(description = "Organization creation data", required = true) @Valid @RequestBody OrgCreateDtoRequest orgCreateDtoRequest) {
        return ResponseEntity.status(201).body(orgService.createOrg(orgCreateDtoRequest));
    }

    @Operation(summary = "Get all organizations", description = "Retrieves a list of all organizations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved organizations")
    })
    @GetMapping("/")
    public ResponseEntity<List<OrgDtoResponse>> getAllOrgs() {
        return ResponseEntity.ok(orgService.getAllOrgs());
    }

    @Operation(summary = "Create a new area", description = "Creates a new area within the specified organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Area created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid area data"),
            @ApiResponse(responseCode = "404", description = "Organization not found")
    })
    @PostMapping("/{orgId}/area")
    public ResponseEntity<AreaDtoResponse> createArea(
            @Parameter(description = "ID of the organization", required = true) @PathVariable("orgId") Long orgId,
            @Parameter(description = "Area creation data", required = true) @Valid @RequestBody AreaCreateDtoRequest areaCreateDtoRequest) {
        return ResponseEntity.status(201).body(areaService.createArea(orgId, areaCreateDtoRequest));
    }

    @Operation(summary = "Get areas by organization", description = "Retrieves all areas within a specific organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved areas"),
            @ApiResponse(responseCode = "404", description = "Organization not found")
    })
    @GetMapping("/{orgId}/area")
    public ResponseEntity<List<AreaDtoResponse>> getAreas(
            @Parameter(description = "ID of the organization", required = true) @PathVariable("orgId") Long orgId) {
        return ResponseEntity.ok(areaService.getAreas(orgId));
    }

    @Operation(summary = "Create a new subarea", description = "Creates a new subarea within the specified area and organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Subarea created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid subarea data"),
            @ApiResponse(responseCode = "404", description = "Organization or area not found")
    })
    @PostMapping("/{orgId}/area/{areaId}/subarea")
    public ResponseEntity<SubareaDtoResponse> createSubarea(
            @Parameter(description = "ID of the organization", required = true) @PathVariable("orgId") Long orgId,
            @Parameter(description = "ID of the area", required = true) @PathVariable("areaId") Long areaId,
            @Parameter(description = "Subarea creation data", required = true) @Valid @RequestBody SubareaCreateDtoRequest subareaCreateDtoRequest) {
        return ResponseEntity.status(201).body(subareaService.createSubarea(orgId, areaId, subareaCreateDtoRequest));
    }

    @Operation(summary = "Get subareas by area", description = "Retrieves all subareas within a specific area")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved subareas"),
            @ApiResponse(responseCode = "404", description = "Area not found")
    })
    @GetMapping("/{orgId}/area/{areaId}/subarea")
    public ResponseEntity<List<SubareaDtoResponse>> getSubareas(
            @Parameter(description = "ID of the organization", required = true) @PathVariable("orgId") Long orgId,
            @Parameter(description = "ID of the area", required = true) @PathVariable("areaId") Long areaId) {
        return ResponseEntity.ok(subareaService.getSubareas(areaId));
    }
}
