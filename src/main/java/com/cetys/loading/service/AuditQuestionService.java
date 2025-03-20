package com.cetys.loading.service;

import com.cetys.loading.model.AuditQuestion;
import com.cetys.loading.repository.AuditQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditQuestionService {

    @Autowired
    private AuditQuestionRepository auditQuestionRepository;

    public List<AuditQuestion> getAllAuditQuestions() {
        return auditQuestionRepository.findAll();
    }

    public AuditQuestion getAuditQuestionById(Long id) {
        Optional<AuditQuestion> auditQuestion = auditQuestionRepository.findById(id);
        return auditQuestion.orElse(null);
    }

    public AuditQuestion createAuditQuestion(AuditQuestion auditQuestion) {
        return auditQuestionRepository.save(auditQuestion);
    }

    public AuditQuestion updateAuditQuestion(Long id, AuditQuestion auditQuestionDetails) {
        Optional<AuditQuestion> auditQuestionOptional = auditQuestionRepository.findById(id);
        if (auditQuestionOptional.isPresent()) {
            AuditQuestion auditQuestion = auditQuestionOptional.get();
            auditQuestion.setAuditCategory(auditQuestionDetails.getAuditCategory());
            auditQuestion.setBaseQuestion(auditQuestionDetails.getBaseQuestion());
            auditQuestion.setQuestion(auditQuestionDetails.getQuestion());
            return auditQuestionRepository.save(auditQuestion);
        } else {
            return null;
        }
    }

    public void deleteAuditQuestion(Long id) {
        auditQuestionRepository.deleteById(id);
    }
}