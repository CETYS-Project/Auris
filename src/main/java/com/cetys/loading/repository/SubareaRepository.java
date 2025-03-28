package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.Subarea;

public interface SubareaRepository extends JpaRepository<Subarea, Long> {
    List<Subarea> findByAreaId(Long areaId);
}
