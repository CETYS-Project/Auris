package com.cetys.loading.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "audit_question")
@Getter
@Setter
public class AuditQuestion extends BaseEntity {

    public static AuditQuestion fromBaseQuestion(BaseQuestion baseQuestion, AuditCategory auditCategory) {
        AuditQuestion auditQuestion = new AuditQuestion();
        auditQuestion.setBaseQuestion(baseQuestion);
        auditQuestion.setQuestion(baseQuestion.getQuestion());
        auditQuestion.setAuditCategory(auditCategory);
        return auditQuestion;
    }

    @Id
    @Column(name = "audit_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "audit_category_id")
    AuditCategory auditCategory;

    @ManyToOne()
    @JoinColumn(name = "base_question_id")
    BaseQuestion baseQuestion;

    @Column(name = "question")
    String question;

}
