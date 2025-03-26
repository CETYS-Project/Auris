package com.cetys.loading.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "base_question")
@Getter
@Setter
public class BaseQuestion extends BaseEntity {

    public BaseQuestion(String question, BaseCategory category) {
        this.question = question;
        this.baseCategory = category;
    }

    @Id
    @Column(name = "base_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long baseQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_category_id")
    BaseCategory baseCategory;

    @Column(name = "question")
    String question;
}
