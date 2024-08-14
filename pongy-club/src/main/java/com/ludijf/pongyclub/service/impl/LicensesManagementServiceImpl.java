package com.ludijf.pongyclub.service.impl;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.dto.LicensePaymentDateDTO;
import com.ludijf.pongyclub.entity.dto.LicenseStartDateDTO;
import com.ludijf.pongyclub.repository.LicenseDao;
import com.ludijf.pongyclub.service.LicensesManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LicensesManagementServiceImpl implements LicensesManagementService {

    private LicenseDao licenseDao;

    @Autowired
    public LicensesManagementServiceImpl(LicenseDao licenseDao) {
        this.licenseDao = licenseDao;
    }
    @Override
    public List<License> getAllLicenses() {
        return licenseDao.findAll();
    }

    @Override
    public List<License> getActiveLicenses() {
        return licenseDao.findByEndDateAfter(LocalDate.now());
    }

    @Override
    public List<License> getUnpaidLicenses() {
        return licenseDao.findByPaymentDateIsNull();
    }

    @Override
    public List<License> getUnstartedLicenses() {
        return licenseDao.findByStartDateIsNull();
    }

    @Override
    public License setPaymentDate(LicensePaymentDateDTO licensePaymentDateDTO) {
        Optional<License> licenseOptional = licenseDao.findById(licensePaymentDateDTO.getLicenseId());
        if (licenseOptional.isPresent()) {
            License license = licenseOptional.get();
            license.setPaymentDate(licensePaymentDateDTO.getPaymentDate());
            return licenseDao.save(license);
        } else {
            throw new NoSuchElementException("License not found");
        }
    }

    @Override
    public License setStartDate(LicenseStartDateDTO licenseStartDateDTO) {
        Optional<License> licenseOptional = licenseDao.findById(licenseStartDateDTO.getLicenseId());
        if (licenseOptional.isPresent()) {
            License license = licenseOptional.get();
            license.setStartDate(licenseStartDateDTO.getStartDate());
            license.setEndDate(setToNextJuly());
            return licenseDao.save(license);
        } else {
            throw new NoSuchElementException("License not found");
        }
    }

    private LocalDate setToNextJuly() {
        LocalDate nextJuly = LocalDate.of(LocalDate.now().getYear(), 7, 1);
        if (LocalDate.now().isAfter(nextJuly)) {
            nextJuly = nextJuly.plusYears(1);
        }
        return nextJuly;
    }


}
