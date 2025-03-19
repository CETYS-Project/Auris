package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="subarea")
@Getter
@Setter
public class Subarea extends BaseEntity {
    @Id
    @Column(name="subarea_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int subarea_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    Area area;

    @Column(name="name")
    String name;
}
