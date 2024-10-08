package com.ludijf.pongyclub.repository;

import com.ludijf.pongyclub.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName (String name);

}
