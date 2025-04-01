package com.cetys.loading.dto.requests;

import com.cetys.loading.model.Org;
import com.cetys.loading.model.Subarea;
import com.cetys.loading.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRoleDtoRequest {

    private Long id;
    private User user;
    private Org org;
    private Subarea allowedSubarea;
}
