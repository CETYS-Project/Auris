package com.cetys.loading.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cetys.loading.dto.AuditCategoryDto;
import com.cetys.loading.dto.AuditInfoDto;
import com.cetys.loading.dto.request.AuditCreateDtoRequest;
import com.cetys.loading.mapper.AuditMapper;
import com.cetys.loading.model.Audit;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.repository.AuditCategoryRepository;
import com.cetys.loading.repository.AuditQuestionRepository;
import com.cetys.loading.repository.AuditRepository;
import com.cetys.loading.repository.SubareaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;
    private final BaseCategoryService baseCategoryService;
    private final AuditCategoryRepository auditCategoryRepository;
    private final BaseQuestionService baseQuestionService;
    private final AuditQuestionRepository auditQuestionRepository;
    private final SubareaRepository subareaRepository;
    private final AuditMapper auditMapper;

    public Audit createAudit(Long subareaId, AuditCreateDtoRequest auditCreateDtoRequest) {
        Subarea subarea = subareaRepository.findById(subareaId)
                .orElseThrow(() -> new EntityNotFoundException("La subárea no existe"));

        Audit audit = auditMapper.toEntity(auditCreateDtoRequest);
        subarea.addAudit(audit);
        auditRepository.save(audit);

        List<BaseCategory> baseCategories = subarea.getBaseCategories();
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

    public AuditInfoDto getAuditInfo(Long auditId) {
        Audit audit = auditRepository.findById(auditId).orElse(null);
        if (audit == null) {
            throw new RuntimeException("Audit not found");
        }
        List<AuditCategory> auditCategories = auditCategoryRepository.findAllByAuditId(audit.getId());
        List<AuditCategoryDto> auditCategoryDtos = new ArrayList<>();
        for (AuditCategory auditCategory : auditCategories) {
            List<AuditQuestion> auditQuestions = auditQuestionRepository
                    .findAllByAuditCategoryId(auditCategory.getId());
            auditCategoryDtos.add(new AuditCategoryDto(auditCategory, auditQuestions));
        }

        return new AuditInfoDto(audit, auditCategoryDtos);
    }

}