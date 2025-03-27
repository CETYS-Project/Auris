package com.cetys.loading.controller;

import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.service.BaseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base-question")
public class BaseQuestionController {

    @Autowired
    private BaseQuestionService baseQuestionService;

    @GetMapping("/")
    public List<BaseQuestion> getAllBaseQuestions() {
        return baseQuestionService.getAllBaseQuestions();
    }

    @GetMapping("/{id}")
    public BaseQuestion getBaseQuestionById(@PathVariable Long id) {
        return baseQuestionService.getBaseQuestionById(id);
    }

    @PostMapping("/")
    public BaseQuestion createBaseQuestion(@RequestBody BaseQuestion baseQuestion) {
        return baseQuestionService.createBaseQuestion(baseQuestion);
    }

    @PutMapping("/{id}")
    public BaseQuestion updateBaseQuestion(@PathVariable Long id, @RequestBody BaseQuestion baseQuestionDetails) {
        return baseQuestionService.updateBaseQuestion(id, baseQuestionDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBaseQuestion(@PathVariable Long id) {
        baseQuestionService.deleteBaseQuestion(id);
    }
}