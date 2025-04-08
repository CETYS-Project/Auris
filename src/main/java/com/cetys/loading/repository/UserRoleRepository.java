package com.cetys.loading.repository;

import com.cetys.loading.model.User;
import com.cetys.loading.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(Long userId);
}
