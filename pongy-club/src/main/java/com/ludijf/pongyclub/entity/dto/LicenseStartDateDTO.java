package com.ludijf.pongyclub.entity.dto;

import java.time.LocalDate;

public class LicenseStartDateDTO {

    private Long licenseId;
    private LocalDate startDate;


    public Long getLicenseId() {
        return licenseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

