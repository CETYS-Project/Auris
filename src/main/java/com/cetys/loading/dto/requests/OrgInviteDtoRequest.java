package com.cetys.loading.dto.requests;

import com.cetys.loading.model.Org;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrgInviteDtoRequest {

    private Long id;
    private Org org;
    private String code;
    private LocalDateTime expires;
}
