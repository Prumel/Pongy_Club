package com.ludijf.pongyclub.entity.dto;

import java.time.LocalDate;

public class LicensePaymentDateDTO {
    private Long licenseId;
    private LocalDate paymentDate;

    // Getters and setters...

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
