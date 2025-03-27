package com.cetys.loading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.Audit;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.repository.AuditCategoryRepository;
import com.cetys.loading.repository.AuditQuestionRepository;
import com.cetys.loading.repository.AuditRepository;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private BaseCategoryService baseCategoryService;

    @Autowired
    private AuditCategoryRepository auditCategoryRepository;

    @Autowired
    private BaseQuestionService baseQuestionService;

    @Autowired
    private AuditQuestionRepository auditQuestionRepository;

    public Audit getAuditById(Long id) {
        Optional<Audit> audit = auditRepository.findById(id);
        return audit.orElse(null);
    }

    public Audit createAudit(Audit audit) {
        Audit a = auditRepository.save(audit);
        Subarea s = a.getSubarea();

        List<BaseCategory> baseCategories = baseCategoryService.getAllBaseCategoriesBySubarea(s.getId());
        List<AuditCategory> auditCategories = new ArrayList<>();

        for (BaseCategory baseCategory : baseCategories) {
            auditCategories.add(AuditCategory.fromBaseCategory(baseCategory, a));
        }

        auditCategoryRepository.saveAll(auditCategories);

        List<AuditQuestion> auditQuestions = new ArrayList<>();

        for (AuditCategory auditCategory : auditCategories) {
            List<BaseQuestion> baseQuestions = baseQuestionService
                    .findAllByBaseCategoryId(auditCategory.getBaseCategory().getId());

            for (BaseQuestion baseQuestion : baseQuestions) {
                auditQuestions.add(AuditQuestion.fromBaseQuestion(baseQuestion, auditCategory));
            }
        }
        auditQuestionRepository.saveAll(auditQuestions);

        return a;
    }

    public List<Audit> getAuditsBySubarea(Long subareaId) {
        return auditRepository.findAllBySubareaId(subareaId);
    }

}