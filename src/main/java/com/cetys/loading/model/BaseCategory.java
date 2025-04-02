package com.cetys.loading.model;

import java.util.ArrayList;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "base_category")
public class BaseCategory extends BaseEntity {

    @Id
    @Column(name = "base_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subarea_id")
    Subarea subarea;

    @Column(name = "s_category")
    SCategory sCategory;

    String name;

    String description;

    @OneToMany(mappedBy = "baseCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    List<BaseQuestion> baseQuestions = new ArrayList<>();

    @OneToMany(mappedBy = "baseCategory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    List<AuditCategory> auditCategories = new ArrayList<>();
}
