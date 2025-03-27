package com.cetys.loading.model;

import com.cetys.loading.enums.SCategory;

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
@Table(name = "audit_category")
@Getter
@Setter
public class AuditCategory extends BaseEntity {

    public static AuditCategory fromBaseCategory(BaseCategory baseCategory, Audit audit) {
        AuditCategory auditCategory = new AuditCategory();
        auditCategory.setBaseCategory(baseCategory);
        auditCategory.setAudit(audit);
        auditCategory.setSCategory(baseCategory.getSCategory());
        auditCategory.setName(baseCategory.getName());
        auditCategory.setDescription(baseCategory.getDescription());
        return auditCategory;
    }

    @Id
    @Column(name = "audit_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id")
    Audit audit;

    @Column(name = "s_category")
    SCategory sCategory;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_category_id")
    BaseCategory baseCategory;
}
