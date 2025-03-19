package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="audit_question")
@Getter
@Setter
public class AuditQuestion extends BaseEntity {

    @Id
    @Column(name="audit_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_category_id")
    AuditCategory auditCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_question_id")
    BaseQuestion baseQuestion;

    @Column(name="question")
    String question;

}
