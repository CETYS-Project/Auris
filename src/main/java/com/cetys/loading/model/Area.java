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
    @Column(name="area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int areaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    Org org;

    @Column(name="name")
    String name;
}
