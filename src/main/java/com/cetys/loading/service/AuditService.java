package com.cetys.loading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cetys.loading.dto.request.AuditCreateDtoRequest;
import com.cetys.loading.dto.response.AuditDtoResponse;
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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;
    private final AuditCategoryRepository auditCategoryRepository;
    private final AuditQuestionRepository auditQuestionRepository;
    private final SubareaRepository subareaRepository;
    private final AuditMapper auditMapper;

    public AuditDtoResponse createAudit(Long subareaId, AuditCreateDtoRequest auditCreateDtoRequest) {
        Subarea subarea = subareaRepository.findById(subareaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La subárea no existe"));

        Audit audit = auditMapper.toEntity(auditCreateDtoRequest);
        subarea.addAudit(audit);
        auditRepository.save(audit);

        List<BaseCategory> baseCategories = subarea.getBaseCategories();
        List<AuditCategory> auditCategories = new ArrayList<>();

        for (BaseCategory baseCategory : baseCategories) {
            auditCategories.add(auditMapper.toAuditCategory(baseCategory, audit));
        }

        auditCategoryRepository.saveAll(auditCategories);

        List<AuditQuestion> auditQuestions = new ArrayList<>();

        for (int i = 0; i < auditCategories.size(); i++) {
            List<BaseQuestion> baseQuestions = baseCategories.get(i).getBaseQuestions();
            AuditCategory auditCategory = auditCategories.get(i);

            for (BaseQuestion baseQuestion : baseQuestions) {
                auditQuestions.add(auditMapper.toAuditQuestion(baseQuestion, auditCategory));
            }
        }
        auditQuestionRepository.saveAll(auditQuestions);

        return auditMapper.toDto(audit);
    }

    public List<AuditDtoResponse> getAuditsBySubareaId(Long subareaId) {
        Subarea subarea = subareaRepository.findById(subareaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La subárea no existe"));

        return subarea.getAudits().stream().map(auditMapper::toDto).collect(Collectors.toList());
    }

}