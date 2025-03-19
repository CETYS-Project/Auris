package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="audit_answer")
@Getter
@Setter
public class AuditAnswer extends BaseEntity {

    @Id
    @Column(name="audit_answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_question_id")
    AuditQuestion auditQuestion;

    @Column(name="score")
    int score;

    @Column(name="notes")
    String notes;

    @Column(name="image_url")
    String imageUrl;

}
