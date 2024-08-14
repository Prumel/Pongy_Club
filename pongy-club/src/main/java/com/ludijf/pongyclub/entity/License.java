package com.ludijf.pongyclub.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class License {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate registrationDate;
    private LocalDate paymentDate;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private LicensedMember licensedMember;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private LicenseType licenseType;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    @Column(name = "licensedMember")
    public LicensedMember getLicensedMember() {
        return licensedMember;
    }
    public LicenseType getLicenseType() {
        return licenseType;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setLicensedMember(LicensedMember licensedMember) {
        this.licensedMember = licensedMember;
    }

    public void setLicenseType(LicenseType licenseType) {
        this.licenseType = licenseType;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public License() {
    }
}

