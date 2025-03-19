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
    @Column(name="audit_question_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditQuestionId;

    @ManyToOne(fetch = FetchType.LAZY)
    AuditCategory auditCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    BaseQuestion baseQuestion;

    @Column(name="question")
    String question;

}
