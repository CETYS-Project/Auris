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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/org")
@RequiredArgsConstructor
public class OrgController {

    private final OrgService orgService;
    private final AreaService areaService;
    private final SubareaService subareaService;

    @GetMapping("/")
    public ResponseEntity<List<OrgDtoResponse>> getAllOrgs() {
        return ResponseEntity.ok(orgService.getAllOrgs());
    }

    @PostMapping("/")
    public ResponseEntity<OrgDtoResponse> createOrg(@Valid @RequestBody OrgCreateDtoRequest orgCreateDtoRequest) {
        return ResponseEntity.ok(orgService.createOrg(orgCreateDtoRequest));
    }

    @PostMapping("/{orgId}/area")
    public ResponseEntity<AreaDtoResponse> createArea(@PathVariable("orgId") Long orgId,
            @Valid @RequestBody AreaCreateDtoRequest areaCreateDtoRequest) {
        return ResponseEntity.ok(areaService.createArea(orgId, areaCreateDtoRequest));
    }

    @GetMapping("/{orgId}/area")
    public ResponseEntity<List<AreaDtoResponse>> getAreas(@PathVariable("orgId") Long orgId) {
        return ResponseEntity.ok(areaService.getAreas(orgId));
    }

    @PostMapping("/{orgId}/area/{areaId}/subarea")
    public ResponseEntity<SubareaDtoResponse> createSubarea(@PathVariable("orgId") Long orgId,
            @PathVariable("areaId") Long areaId, @Valid @RequestBody SubareaCreateDtoRequest subareaCreateDtoRequest) {
        return ResponseEntity.ok(subareaService.createSubarea(orgId, areaId, subareaCreateDtoRequest));
    }

    @GetMapping("/{orgId}/area/{areaId}/subarea")
    public ResponseEntity<List<SubareaDtoResponse>> getSubareas(@PathVariable("orgId") Long orgId,
            @PathVariable("areaId") Long areaId) {
        return ResponseEntity.ok(subareaService.getSubareas(areaId));
    }

}
