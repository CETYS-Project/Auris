package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="audit")
@Getter
@Setter
public class Audit extends BaseEntity {

    @Id
    @Column(name="audit_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditId;

    @ManyToOne
    Subarea subarea;
}
