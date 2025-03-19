package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="audit_category")
@Getter
@Setter
public class AuditCategory extends BaseEntity {

    public static enum SCategory { S1, S2, S3, S4, S5 }

    @Id
    @Column(name="audit_category_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int auditCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    Subarea subarea;

    @Column(name="s_category")
    SCategory sCategory;

    @Column(name="name")
    String name;

    @Column(name="description")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    BaseCategory baseCategory;
}
