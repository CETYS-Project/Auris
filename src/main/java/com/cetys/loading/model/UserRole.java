package com.cetys.loading.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user_role")
@Getter
@Setter
public class UserRole extends BaseEntity {

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne()
    @JoinColumn(name = "org_id")
    Org org;

    @ManyToOne()
    @JoinColumn(name = "allowed_subarea_id")
    Subarea allowedSubarea;
}
