package com.cetys.loading.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cetys.loading.dto.request.AnswerDtoRequest;
import com.cetys.loading.dto.response.AuditCategoryDtoResponse;
import com.cetys.loading.dto.response.AuditDtoResponse;
import com.cetys.loading.mapper.AuditMapper;
import com.cetys.loading.model.Audit;
import com.cetys.loading.model.AuditAnswer;
import com.cetys.loading.model.AuditCategory;
import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.projection.AuditQuestionProjection;
import com.cetys.loading.repository.AuditAnswerRepository;
import com.cetys.loading.repository.AuditCategoryRepository;
import com.cetys.loading.repository.AuditQuestionRepository;
import com.cetys.loading.repository.AuditRepository;
import com.cetys.loading.repository.SubareaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;
    private final AuditCategoryRepository auditCategoryRepository;
    private final AuditQuestionRepository auditQuestionRepository;
    private final AuditAnswerRepository auditAnswerRepository;
    private final SubareaRepository subareaRepository;
    private final AuditMapper auditMapper;

    @Transactional
    public void createAudit(Long subareaId) {
        Subarea subarea = subareaRepository.findById(subareaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "La subárea no existe"));

        Audit audit = Audit.builder().build();
        subarea.addAudit(audit);
        auditRepository.save(audit);

        List<BaseCategory> baseCategories = subarea.getBaseCategories();
        List<AuditCategory> auditCategories = new ArrayList<>();

        for (BaseCategory baseCategory : baseCategories) {
            auditCategories.add(
                    auditMapper.toAuditCategory(baseCategory, audit, baseCategory.getSCategory()));
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
    }

    public List<AuditDtoResponse> getAuditsBySubareaId(Long subareaId) {
        Subarea subarea = subareaRepository.findByIdWithPrefetch(subareaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "La subárea no existe"));
        // We are fetching everything anyways, so this won't be as bad as it looks
        List<Audit> audits = subarea.getAudits();
        List<AuditDtoResponse> auditDtoResponses = new ArrayList<>();
        for (Audit audit : audits) {
            List<AuditCategory> auditCategories = audit.getAuditCategories();
            List<AuditCategoryDtoResponse> auditCategoryDtoResponses = new ArrayList<>();
            int totalAnsweredQuestions = 0;
            int totalQuestions = 0;
            for (AuditCategory auditCategory : auditCategories) {
                int categoryAnsweredQuestions = 0;
                int categoryTotalQuestions = 0;
                List<AuditQuestion> auditQuestions = auditCategory.getAuditQuestions();
                for (AuditQuestion auditQuestion : auditQuestions) {
                    AuditAnswer auditAnswer = auditQuestion.getAuditAnswer();
                    if (auditAnswer != null) {
                        categoryAnsweredQuestions++;
                    }
                    categoryTotalQuestions++;
                }
                totalAnsweredQuestions += categoryAnsweredQuestions;
                totalQuestions += categoryTotalQuestions;
                auditCategoryDtoResponses.add(auditMapper.toDto(auditCategory, categoryAnsweredQuestions,
                        categoryTotalQuestions, auditCategory.getSCategory()));
            }
            auditDtoResponses.add(auditMapper.toDto(audit, totalAnsweredQuestions, totalQuestions,
                    auditCategoryDtoResponses));
        }
        return auditDtoResponses;
    }

    // TODO: How to calculate the score for each category?
    public void getAuditResult(Long auditId) {
        Audit audit = auditRepository.findById(auditId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "La auditoría no existe"));
        List<AuditCategory> auditCategories = audit.getAuditCategories();
        List<Long> auditCategoryIds = auditCategories.stream()
                .map(AuditCategory::getId).collect(Collectors.toList());

        // All in one query
        List<AuditQuestionProjection> auditQuestions = auditQuestionRepository
                .findByAuditCategoryIdIn(auditCategoryIds);

        HashMap<Long, Integer> pointsPerCategory = new HashMap<>();
        HashMap<Long, Integer> totalPointsPerCategory = new HashMap<>();

        for (AuditQuestionProjection auditQuestion : auditQuestions) {
            Long auditCategoryId = auditQuestion.getAuditCategoryId();
            if (auditQuestion.getAuditAnswer() != null) {
                pointsPerCategory.put(auditCategoryId,
                        pointsPerCategory.getOrDefault(auditCategoryId, 0)
                                + auditQuestion.getAuditAnswer().getScore());
            }
            totalPointsPerCategory.put(auditCategoryId,
                    totalPointsPerCategory.getOrDefault(auditCategoryId, 0)
                            + auditQuestion.getAuditAnswer().getScore());
        }

        List<AuditCategoryDtoResponse> auditCategoriesDto = auditCategories.stream().map(auditCategory -> {
            return auditMapper.toDto(auditCategory,
                    pointsPerCategory.getOrDefault(auditCategory.getId(), 0),
                    totalPointsPerCategory.getOrDefault(auditCategory.getId(), 0),
                    auditCategory.getSCategory());
        }).collect(Collectors.toList());

        Integer totalQuestionsAnswered = auditCategoriesDto.stream()
                .map(AuditCategoryDtoResponse::getQuestionsAnswered)
                .reduce(0, (a, b) -> a + b);
        Integer totalQuestions = auditCategoriesDto.stream()
                .map(AuditCategoryDtoResponse::getTotalQuestions)
                .reduce(0, (a, b) -> a + b);

        auditMapper.toDto(audit, totalQuestionsAnswered, totalQuestions,
                auditCategoriesDto);

        return;
    }

    @Transactional
    public void answerQuestion(Long questionId, AnswerDtoRequest answerDtoRequest) {
        AuditQuestion auditQuestion = auditQuestionRepository.findById(questionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "La pregunta no existe"));

        AuditAnswer auditAnswer = auditQuestion.getAuditAnswer();
        // Try to update the answer
        if (auditAnswer != null) {
            auditAnswer.setScore(answerDtoRequest.getScore());
            auditAnswer.setNotes(answerDtoRequest.getNotes());
            auditAnswer.setImageUrl(answerDtoRequest.getImageUrl());
        } else {
            auditAnswer = auditMapper.toEntity(answerDtoRequest);
        }

        auditQuestion.setAuditAnswer(auditAnswer);

        auditAnswerRepository.save(auditAnswer);
    }

    @Transactional
    public void answerQuestions(List<AnswerDtoRequest> answerDtoRequests) {
        List<Long> questionIds = answerDtoRequests.stream()
                .map(AnswerDtoRequest::getQuestionId)
                .collect(Collectors.toList());

        List<AuditQuestion> questions = auditQuestionRepository.findAllById(questionIds);
        Map<Long, AuditQuestion> questionMap = questions.stream()
                .collect(Collectors.toMap(AuditQuestion::getId, q -> q));

        List<AuditAnswer> answersToSave = new ArrayList<>();

        for (AnswerDtoRequest answerRequest : answerDtoRequests) {
            AuditQuestion question = questionMap.get(answerRequest.getQuestionId());
            if (question == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "La pregunta no existe: " + answerRequest.getQuestionId());
            }

            AuditAnswer answer = question.getAuditAnswer();
            if (answer != null) {
                answer.setScore(answerRequest.getScore());
                answer.setNotes(answerRequest.getNotes());
                answer.setImageUrl(answerRequest.getImageUrl());
            } else {
                answer = auditMapper.toEntity(answerRequest);
                question.setAuditAnswer(answer);
            }
            answersToSave.add(answer);
        }

        auditAnswerRepository.saveAll(answersToSave);
    }

}