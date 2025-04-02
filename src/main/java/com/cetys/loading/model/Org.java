package com.cetys.loading.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "org")
public class Org extends BaseEntity {

    @Id
    @Column(name = "org_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "org", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Area> areas;

    public void addArea(Area area) {
        areas.add(area);
        area.setOrg(this);
    }

    public void removeArea(Area area) {
        areas.remove(area);
        area.setOrg(null);
    }
}
