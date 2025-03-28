package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByOrgId(Long orgId);
}
