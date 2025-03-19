package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="base_question")
@Getter
@Setter
public class BaseQuestion extends BaseEntity {


    @Id
    @Column(name="base_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int baseQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_category_id")
    BaseCategory baseCategory;

    @Column(name="question")
    String question;
}
