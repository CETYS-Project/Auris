package com.cetys.loading.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoRequest {
    private String name;
    private String email;
    private String password;
}