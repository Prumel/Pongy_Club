package com.ludijf.pongyclub.controller;

import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.dto.LicensedMembersRoleUpdateDTO;
import com.ludijf.pongyclub.service.LicensedMemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/admin/licensedmembers")
@CrossOrigin("${front.url}")
public class LicensedMemberManagementController {

    private LicensedMemberManagementService licensedMemberManagementService;

    @Autowired
    public LicensedMemberManagementController(LicensedMemberManagementService licensedMemberManagementService) {
        this.licensedMemberManagementService = licensedMemberManagementService;
    }

    @GetMapping("/all")
    public List<LicensedMember> getAllLicensedMembers() {
        return licensedMemberManagementService.getAllLicensedMembers();
    }


    /* ************ SECURITY : EXAMPLE OF PARAMETER INJECTION ************
    @PutMapping("/addRole/{id}")
    public LicensedMember addRoleToLicensedMember(@PathVariable Long id, @RequestBody Role newRole) {
        return licensedMemberManagementService.updateLicensedMemberRoles(id, newRole);
    }
*/
    @PutMapping("/add-role")
    public LicensedMember addRoleToLicensedMember(@RequestBody LicensedMembersRoleUpdateDTO roleUpdateDTO) {
        return licensedMemberManagementService.updateLicensedMemberRoles(roleUpdateDTO.getMemberId(), roleUpdateDTO.getNewRole());
    }

    @PutMapping("/user-role-only")
    public LicensedMember replaceRolesWithUserRole(@RequestBody LicensedMembersRoleUpdateDTO roleUpdateDTO) {
        return licensedMemberManagementService.setOnlyUserRole(roleUpdateDTO.getMemberId());
    }


}


