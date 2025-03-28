package com.cetys.loading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.Area;
import com.cetys.loading.repository.AreaRepository;

@Service
public class AreaService {
    @Autowired
    AreaRepository areaRepository;

    public List<Area> getAreaList() {
        List<Area> areas = areaRepository.findAll();
        return areas;
    }

    public List<Area> getAreaListByOrgId(Long orgId) {
        List<Area> areas = areaRepository.findByOrgId(orgId);
        return areas;
    }

    public Area getAreaById(Long id) {
        Optional<Area> area = areaRepository.findById(id);
        return area.orElse(null);
    }

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public Area updateArea(Long id, Area areaDetails) {
        Optional<Area> areaOptional = areaRepository.findById(id);
        if (areaOptional.isPresent()) {
            Area area = areaOptional.get();
            area.setName(areaDetails.getName());
            area.setOrg(areaDetails.getOrg());
            return areaRepository.save(area);
        } else {
            return null;
        }
    }
}
