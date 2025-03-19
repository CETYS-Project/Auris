package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="org")
@Getter
@Setter
public class Org extends BaseEntity {

    @Id
    @Column(name="org_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int org_id;

    @Column(name="name")
    String name;
}
