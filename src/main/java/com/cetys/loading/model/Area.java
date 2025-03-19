package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="area")
@Getter
@Setter
public class Area extends BaseEntity {

    @Id
    @Column(name="area_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int areaId;

    @ManyToOne(fetch = FetchType.LAZY)
    Org org;

    @Column(name="name")
    String name;
}
