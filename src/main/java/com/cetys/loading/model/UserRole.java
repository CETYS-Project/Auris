package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;

@Entity
@Table(name="app_user_role")
@Getter
@Setter
public class UserRole extends BaseEntity {

    @Id
    @Column(name="user_role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name="user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="org_id")
    Org org;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="allowed_subarea_id")
    Subarea allowedSubarea;
}
