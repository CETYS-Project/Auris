package com.cetys.loading.model;

import java.util.List;

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
@Table(name = "subarea")
public class Subarea extends BaseEntity {
    @Id
    @Column(name = "subarea_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    Area area;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "subarea", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<BaseCategory> baseCategories;

    @OneToMany(mappedBy = "subarea", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Audit> audits;

    public void addBaseCategory(BaseCategory baseCategory) {
        baseCategories.add(baseCategory);
        baseCategory.setSubarea(this);
    }

    public void removeBaseCategory(BaseCategory baseCategory) {
        baseCategories.remove(baseCategory);
        baseCategory.setSubarea(null);
    }

    public void addAudit(Audit audit) {
        audits.add(audit);
        audit.setSubarea(this);
    }

    public void removeAudit(Audit audit) {
        audits.remove(audit);
        audit.setSubarea(null);
    }
}
