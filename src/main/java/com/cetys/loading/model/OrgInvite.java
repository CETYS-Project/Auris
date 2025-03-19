package com.cetys.loading.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="org_invite")
@Getter
@Setter
public class OrgInvite extends BaseEntity {

    @Id
    @Column(name="org_invite_id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orgInviteId;

    @ManyToOne(fetch = FetchType.LAZY)
    Org org;

    @Column(name="code")
    String code;

    @Column(name="expires")
    LocalDateTime expires;
}
