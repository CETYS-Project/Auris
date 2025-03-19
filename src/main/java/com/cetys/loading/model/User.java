package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="app_user")
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;
}
