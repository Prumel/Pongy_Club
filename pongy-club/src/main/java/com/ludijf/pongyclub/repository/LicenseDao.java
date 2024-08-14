package com.ludijf.pongyclub.repository;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.LicensedMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LicenseDao extends JpaRepository<License, Long> {

    List<License> findByPaymentDateIsNull();
    List<License> findByStartDateIsNull();
    List<License> findByEndDateAfter(LocalDate date);
}