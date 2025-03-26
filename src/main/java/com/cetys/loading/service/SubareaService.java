package com.cetys.loading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.repository.BaseCategoryRepository;
import com.cetys.loading.repository.BaseQuestionRepository;
import com.cetys.loading.repository.SubareaRepository;

@Service
public class SubareaService {

    @Autowired
    private SubareaRepository subareaRepository;

    @Autowired
    private BaseCategoryRepository baseCategoryRepository;

    @Autowired
    private BaseQuestionRepository baseQuestionRepository;

    public List<Subarea> getAllSubareas() {
        return subareaRepository.findAll();
    }

    public Subarea getSubareaById(Long id) {
        Optional<Subarea> subarea = subareaRepository.findById(id);
        return subarea.orElse(null);
    }

    public Subarea createSubarea(Subarea subarea) {
        Subarea s = subareaRepository.save(subarea);

        List<BaseCategory> baseCategories = BaseCategoryService.getDefaultBaseCategories();
        for (BaseCategory baseCategory : baseCategories) {
            baseCategory.setSubarea(s);
        }
        baseCategoryRepository.saveAll(baseCategories);

        List<BaseQuestion> baseQuestions = BaseQuestionService.getDefaultBaseQuestions(baseCategories);
        baseQuestionRepository.saveAll(baseQuestions);

        return s;
    }

    public Subarea updateSubarea(Long id, Subarea subareaDetails) {
        Optional<Subarea> subareaOptional = subareaRepository.findById(id);
        if (subareaOptional.isPresent()) {
            Subarea subarea = subareaOptional.get();
            subarea.setArea(subareaDetails.getArea());
            subarea.setName(subareaDetails.getName());
            return subareaRepository.save(subarea);
        } else {
            return null;
        }
    }

    public void deleteSubarea(Long id) {
        subareaRepository.deleteById(id);
    }
}