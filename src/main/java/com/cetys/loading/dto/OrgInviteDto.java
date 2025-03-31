package com.cetys.loading.dto;

import com.cetys.loading.model.Org;
import com.cetys.loading.model.OrgInvite;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrgInviteDto {

    private Long id;
    private Org org;
    private String code;
    private LocalDateTime expires;

    public OrgInviteDto() {
    }

    public OrgInviteDto(Long id, Org org, String code, LocalDateTime expires) {
        this.id = id;
        this.org = org;
        this.code = code;
        this.expires = expires;
    }

    public static OrgInviteDto fromEntity(OrgInvite orgInvite) {
        OrgInviteDto dto = new OrgInviteDto();
        dto.setId(orgInvite.getId());
        dto.setOrg(orgInvite.getOrg());
        dto.setCode(orgInvite.getCode());
        dto.setExpires(orgInvite.getExpires());
        return dto;
    }
}
