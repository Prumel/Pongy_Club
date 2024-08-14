package com.ludijf.pongyclub.repository;

import com.ludijf.pongyclub.entity.LicensedMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicensedMemberDao extends JpaRepository<LicensedMember, Long> {
    Optional<LicensedMember> findByUsername(String username);
    Boolean existsByUsername (String username);

}
