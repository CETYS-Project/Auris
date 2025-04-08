package com.cetys.loading.service;

import com.cetys.loading.model.UserRole;
import com.cetys.loading.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRole> getRolesByUserId(Long userId) {
        return userRoleRepository.findByUser(userId);
    }

}
