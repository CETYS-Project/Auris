package com.cetys.loading.dto.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoResponse {

    private Long id;
    private String name;
    private String email;
}
