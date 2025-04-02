package com.cetys.loading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cetys.loading.model.Org;

public interface OrgRepository extends JpaRepository<Org, Long> {
}
