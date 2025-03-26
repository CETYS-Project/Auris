package com.cetys.loading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.BaseQuestion;

public interface BaseQuestionRepository extends JpaRepository<BaseQuestion, Long> {
    List<BaseQuestion> findAllByBaseCategoryId(Long baseCategoryId);
}
