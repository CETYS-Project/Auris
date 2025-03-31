package com.cetys.loading.dto;

import com.cetys.loading.model.Org;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.model.User;
import com.cetys.loading.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {

    private Long id;
    private User user;
    private Org org;
    private Subarea allowedSubarea;

    public UserRoleDto() {
    }

    public UserRoleDto(Long id, User user, Org org, Subarea allowedSubarea) {
        this.id = id;
        this.user = user;
        this.org = org;
        this.allowedSubarea = allowedSubarea;
    }

    public static UserRoleDto fromEntity(UserRole userRole) {
        UserRoleDto dto = new UserRoleDto();
        dto.setId(userRole.getId());
        dto.setUser(userRole.getUser());
        dto.setOrg(userRole.getOrg());
        dto.setAllowedSubarea(userRole.getAllowedSubarea());
        return dto;
    }
}
