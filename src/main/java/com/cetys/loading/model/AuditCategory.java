package com.cetys.loading.model;

import java.util.List;

import com.cetys.loading.enums.SCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "audit_category")
public class AuditCategory extends BaseEntity {

    public static AuditCategory fromBaseCategory(BaseCategory baseCategory, Audit audit) {
        return AuditCategory.builder()
                .baseCategory(baseCategory)
                .audit(audit)
                .sCategory(baseCategory.getSCategory())
                .name(baseCategory.getName())
                .description(baseCategory.getDescription())
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_category_id")
    Long id;

    @Column(name = "s_category")
    SCategory sCategory;

    String name;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "audit_id")
    Audit audit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_category_id")
    BaseCategory baseCategory;

    @OneToMany(mappedBy = "auditCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<AuditQuestion> auditQuestions;
}
