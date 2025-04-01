package com.cetys.loading.dto.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoRequest {

    private Long id;
    private String name;
    private String email;
}
