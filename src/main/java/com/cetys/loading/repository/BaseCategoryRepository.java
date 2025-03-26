package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.BaseCategory;

public interface BaseCategoryRepository extends JpaRepository<BaseCategory, Long> {
    List<BaseCategory> findAllBySubareaId(Long subareaId);
}
