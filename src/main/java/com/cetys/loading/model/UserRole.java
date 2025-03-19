package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.time.LocalDateTime;

@Entity
@Table(name="user_role")
@Getter
@Setter
public class UserRole extends BaseEntity {

    @Id
    @Column(name="user_role_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    Org org;

    @ManyToOne(fetch = FetchType.LAZY)
    Subarea allowedSubarea;
}
