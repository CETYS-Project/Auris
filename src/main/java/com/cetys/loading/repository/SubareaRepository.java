package com.cetys.loading.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetys.loading.model.Subarea;

public interface SubareaRepository extends JpaRepository<Subarea, Long> {
    List<Subarea> findByAreaId(Long areaId);

    @Query("SELECT s FROM Subarea s " +
            "LEFT JOIN s.audits a " +
            "LEFT JOIN a.auditCategories ac " +
            "LEFT JOIN ac.auditQuestions aq " +
            "LEFT JOIN aq.auditAnswer aa " +
            "WHERE s.id = :subareaId")
    Optional<Subarea> findByIdWithPrefetch(@Param("subareaId") Long subareaId);
}
