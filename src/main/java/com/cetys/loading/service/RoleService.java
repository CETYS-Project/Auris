package com.cetys.loading.service;

import com.cetys.loading.model.*;
import com.cetys.loading.repository.RoleRepository;
import com.cetys.loading.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public void assignRoleToUser(User user, Role role, Org org, Subarea subarea) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setOrg(org);
        userRole.setAllowedSubarea(subarea);

        userRoleRepository.save(userRole);
    }

    public Set<Role> getRolesForUser(User user) {
        List<UserRole> userRoles = userRoleRepository.findByUser(user.getId());
        return userRoles.stream()
                .map(UserRole::getRole)
                .collect(Collectors.toSet());
    }
}
