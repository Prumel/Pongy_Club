package com.ludijf.pongyclub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class LicenseType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private LocalDate registrationDate;
    private LocalDate deactivationDate;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getDeactivationDate() {
        return deactivationDate;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public LicenseType() {
    }
}
