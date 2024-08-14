package com.ludijf.pongyclub.service.impl;

import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;
import com.ludijf.pongyclub.repository.LicensedMemberDao;
import com.ludijf.pongyclub.repository.RoleDao;
import com.ludijf.pongyclub.service.LicensedMemberManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class LicensedMemberManagementServiceImpl implements LicensedMemberManagementService {

    private LicensedMemberDao licensedMemberDao;
    private final RoleDao roleDao;

    @Autowired
    public LicensedMemberManagementServiceImpl(RoleDao roleDao, LicensedMemberDao licensedMemberDao) {
        this.licensedMemberDao = licensedMemberDao;
        this.roleDao = roleDao;
    }

    @Override
    public List<LicensedMember> getAllLicensedMembers() {
        return licensedMemberDao.findAll();
    }
    @Override
    public LicensedMember updateLicensedMemberRoles(long id, Role newRole) {
        LicensedMember licensedMember = licensedMemberDao.findById(id).get();
        licensedMember.getRoles().add(newRole);
        return licensedMemberDao.save(licensedMember);
    }
    @Override
    public LicensedMember setOnlyUserRole(Long id) {
        LicensedMember licensedMember = licensedMemberDao.findById(id).get();
        Role userRole = roleDao.findByName("USER").get();
        licensedMember.setRoles(Collections.singletonList(userRole));
        return licensedMemberDao.save(licensedMember);
    }


}
