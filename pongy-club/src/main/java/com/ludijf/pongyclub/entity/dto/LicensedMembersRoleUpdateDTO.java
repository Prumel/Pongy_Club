package com.ludijf.pongyclub.entity.dto;

import com.ludijf.pongyclub.entity.Role;

public class LicensedMembersRoleUpdateDTO {

    private Long memberId;
    private Role newRole;

    public Long getMemberId() {
        return memberId;
    }
    public Role getNewRole() {
        return newRole ;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public void setNewRole(Role newRole) {
        this.newRole = newRole;
    }

    public LicensedMembersRoleUpdateDTO() {
    }
}
