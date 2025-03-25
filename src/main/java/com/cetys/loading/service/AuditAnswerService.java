package com.cetys.loading.service;

import com.cetys.loading.model.AuditAnswer;
import com.cetys.loading.repository.AuditAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditAnswerService {

    @Autowired
    private AuditAnswerRepository auditAnswerRepository;

    public List<AuditAnswer> getAllAuditAnswers() {
        return auditAnswerRepository.findAll();
    }

    public AuditAnswer getAuditAnswerById(Long id) {
        Optional<AuditAnswer> auditAnswer = auditAnswerRepository.findById(id);
        return auditAnswer.orElse(null);
    }

    public AuditAnswer createAuditAnswer(AuditAnswer auditAnswer) {
        return auditAnswerRepository.save(auditAnswer);
    }

    public AuditAnswer updateAuditAnswer(Long id, AuditAnswer auditAnswerDetails) {
        Optional<AuditAnswer> auditAnswerOptional = auditAnswerRepository.findById(id);
        if (auditAnswerOptional.isPresent()) {
            AuditAnswer auditAnswer = auditAnswerOptional.get();
            auditAnswer.setAuditQuestion(auditAnswerDetails.getAuditQuestion());
            auditAnswer.setScore(auditAnswerDetails.getScore());
            auditAnswer.setNotes(auditAnswerDetails.getNotes());
            auditAnswer.setImageUrl(auditAnswerDetails.getImageUrl());
            return auditAnswerRepository.save(auditAnswer);
        } else {
            return null;
        }
    }

    public void deleteAuditAnswer(Long id) {
        auditAnswerRepository.deleteById(id);
    }
}