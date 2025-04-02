package com.cetys.loading.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "org_invite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrgInvite extends BaseEntity {

    @Id
    @Column(name = "org_invite_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "org_id")
    Org org;

    @Column(name = "code")
    String code;

    @Column(name = "expires")
    LocalDateTime expires;
}
