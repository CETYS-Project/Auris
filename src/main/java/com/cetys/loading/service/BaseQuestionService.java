package com.cetys.loading.service;

import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.repository.BaseQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseQuestionService {

    @Autowired
    private BaseQuestionRepository baseQuestionRepository;

    public List<BaseQuestion> getAllBaseQuestions() {
        return baseQuestionRepository.findAll();
    }

    public BaseQuestion getBaseQuestionById(Long id) {
        Optional<BaseQuestion> baseQuestion = baseQuestionRepository.findById(id);
        return baseQuestion.orElse(null);
    }

    public BaseQuestion createBaseQuestion(BaseQuestion baseQuestion) {
        return baseQuestionRepository.save(baseQuestion);
    }

    public BaseQuestion updateBaseQuestion(Long id, BaseQuestion baseQuestionDetails) {
        Optional<BaseQuestion> baseQuestionOptional = baseQuestionRepository.findById(id);
        if (baseQuestionOptional.isPresent()) {
            BaseQuestion baseQuestion = baseQuestionOptional.get();
            baseQuestion.setBaseCategory(baseQuestionDetails.getBaseCategory());
            baseQuestion.setQuestion(baseQuestionDetails.getQuestion());
            return baseQuestionRepository.save(baseQuestion);
        } else {
            return null;
        }
    }

    public void deleteBaseQuestion(Long id) {
        baseQuestionRepository.deleteById(id);
    }
}