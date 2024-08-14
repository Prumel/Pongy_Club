package com.ludijf.pongyclub.service;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;

import java.util.List;


public interface LicensedMemberManagementService {

    /**
     * Retrieves all licensed members.
     *
     * @return a list of all licensed members.
     */
    List<LicensedMember> getAllLicensedMembers();


    /**
     * Updates the roles of a licensed member.
     *
     * @param id the ID of the licensed member to update.
     * @param newRole the new role to assign to the licensed member.
     * @return the updated licensed member with a new list of roles.
     */
    LicensedMember updateLicensedMemberRoles(long id, Role newRole);

    /**
     * Sets the roles of a licensed member to only "USER".
     *
     * @param id the ID of the licensed member to update.
     * @return the updated licensed member with only the "USER" role.
     */
    LicensedMember setOnlyUserRole(Long id);
}
