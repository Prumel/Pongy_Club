package com.ludijf.pongyclub.service.impl;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.LicenseType;
import com.ludijf.pongyclub.entity.LicensedMember;
import com.ludijf.pongyclub.entity.Role;
import com.ludijf.pongyclub.entity.dto.RegisterDTO;
import com.ludijf.pongyclub.repository.LicenseTypeDao;
import com.ludijf.pongyclub.repository.LicensedMemberDao;
import com.ludijf.pongyclub.repository.RoleDao;
import com.ludijf.pongyclub.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private LicensedMemberDao licensedMemberDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;
    private LicenseTypeDao licenseTypeDao;

    @Autowired
    public RegistrationServiceImpl(LicensedMemberDao licensedMemberDao, RoleDao roleDao, PasswordEncoder passwordEncoder, LicenseTypeDao licenseTypeDao) {
        this.licensedMemberDao = licensedMemberDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
        this.licenseTypeDao = licenseTypeDao;
    }

    @Override
    public ResponseEntity<String> register(RegisterDTO registerDTO) {
        if (licensedMemberDao.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        LicensedMember licensedMember = new LicensedMember();
        licensedMember.setUsername(registerDTO.getUsername());
        licensedMember.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        licensedMember.setFirstName(registerDTO.getFirstName());
        licensedMember.setLastName(registerDTO.getLastName());
        licensedMember.setPhoneNumber(registerDTO.getPhoneNumber());
        licensedMember.setBirthdate(registerDTO.getBirthdate());
        licensedMember.setAddress(registerDTO.getAddress());
        licensedMember.setCity(registerDTO.getCity());
        licensedMember.setZipCode(registerDTO.getZipCode());
        licensedMember.setGuardianName(registerDTO.getGuardianName());
        licensedMember.setRegistrationDate(registerDTO.getRegistrationDate());
        List<License> licenses = registerDTO.getLicenseTypeIds().stream()
                .map(id -> {
                    License license = new License();
                    license.setRegistrationDate(LocalDate.now());
                    LicenseType licenseType = licenseTypeDao.findById(id).get();
                    license.setLicenseType(licenseType);
                    license.setLicensedMember(licensedMember);
                    return license;
                }).collect(Collectors.toList());

        licensedMember.setLicenses(licenses);
        Role roles = roleDao.findByName("USER").get();
        licensedMember.setRoles(Collections.singletonList(roles));

        licensedMemberDao.save(licensedMember);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @Override
    public List<LicenseType> getLicenseType() {
        return licenseTypeDao.findAll();
    }
}