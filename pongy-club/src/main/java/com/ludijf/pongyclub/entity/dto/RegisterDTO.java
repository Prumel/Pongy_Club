package com.ludijf.pongyclub.entity.dto;

import java.time.LocalDate;
import java.util.List;

public class RegisterDTO {

    private String guardianName;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phoneNumber;
    private LocalDate birthdate;
    private String address;
    private String city;
    private String zipCode;
    private boolean isChild;
    private LocalDate registrationDate;
    private List<Long> licenseTypeIds;


    public String getGuardianName() {
        return guardianName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public boolean getIsChild() {
        return isChild;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Long> getLicenseTypeIds() {
        return licenseTypeIds;
    }

    public void setLicenseTypeIds(List<Long> licenseTypeIds) {
        this.licenseTypeIds = licenseTypeIds;
    }
}

