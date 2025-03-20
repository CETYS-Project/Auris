package com.cetys.loading.service;

import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.repository.BaseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseCategoryService {

    @Autowired
    private BaseCategoryRepository baseCategoryRepository;

    public List<BaseCategory> getAllBaseCategories() {
        return baseCategoryRepository.findAll();
    }

    public BaseCategory getBaseCategoryById(Long id) {
        Optional<BaseCategory> baseCategory = baseCategoryRepository.findById(id);
        return baseCategory.orElse(null);
    }

    public BaseCategory createBaseCategory(BaseCategory baseCategory) {
        return baseCategoryRepository.save(baseCategory);
    }

    public BaseCategory updateBaseCategory(Long id, BaseCategory baseCategoryDetails) {
        Optional<BaseCategory> baseCategoryOptional = baseCategoryRepository.findById(id);
        if (baseCategoryOptional.isPresent()) {
            BaseCategory baseCategory = baseCategoryOptional.get();
            baseCategory.setSubarea(baseCategoryDetails.getSubarea());
            baseCategory.setSCategory(baseCategoryDetails.getSCategory());
            baseCategory.setName(baseCategoryDetails.getName());
            baseCategory.setDescription(baseCategoryDetails.getDescription());
            return baseCategoryRepository.save(baseCategory);
        } else {
            return null;
        }
    }

    public void deleteBaseCategory(Long id) {
        baseCategoryRepository.deleteById(id);
    }
}