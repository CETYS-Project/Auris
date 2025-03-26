package com.cetys.loading.model;

import com.cetys.loading.enums.SCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "base_category")
@Getter
@Setter
public class BaseCategory extends BaseEntity {

    public BaseCategory(String name, String description, SCategory category) {
        this.name = name;
        this.description = description;
        this.sCategory = category;
    }

    @Id
    @Column(name = "base_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long baseCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    Subarea subarea;

    @Column(name = "s_category")
    SCategory sCategory;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
