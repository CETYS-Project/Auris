package com.cetys.loading.service;

import com.cetys.loading.model.UserRole;
import com.cetys.loading.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRole getUserRoleById(Long id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        return userRole.orElse(null);
    }

    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public UserRole updateUserRole(Long id, UserRole userRoleDetails) {
        Optional<UserRole> userRoleOptional = userRoleRepository.findById(id);
        if (userRoleOptional.isPresent()) {
            UserRole userRole = userRoleOptional.get();
            userRole.setUser(userRoleDetails.getUser());
            userRole.setOrg(userRoleDetails.getOrg());
            userRole.setAllowedSubarea(userRoleDetails.getAllowedSubarea());
            return userRoleRepository.save(userRole);
        } else {
            return null;
        }
    }

    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}