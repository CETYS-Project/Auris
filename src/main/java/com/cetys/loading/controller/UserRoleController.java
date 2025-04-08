package com.cetys.loading.controller;

import com.cetys.loading.model.UserRole;
import com.cetys.loading.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserRoleController {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> getRolesById(@PathVariable Long userId) {
        List<UserRole> roles = userRoleService.getRolesByUserId(userId);
        return ResponseEntity.ok(roles);
    }
}
