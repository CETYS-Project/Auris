package com.cetys.loading.controller;

import com.cetys.loading.model.UserRole;
import com.cetys.loading.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/")
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable Long id) {
        return userRoleService.getUserRoleById(id);
    }

    @PostMapping("/")
    public UserRole createUserRole(@RequestBody UserRole userRole) {
        return userRoleService.createUserRole(userRole);
    }

    @PutMapping("/{id}")
    public UserRole updateUserRole(@PathVariable Long id, @RequestBody UserRole userRoleDetails) {
        return userRoleService.updateUserRole(id, userRoleDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
    }
}