package com.ludijf.pongyclub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class LicensedMember {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String guardianName; // Optional, used if the member is a child
    private String firstName;
    private String lastName;
    private String username; //email
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private LocalDate birthdate;
    private String address;
    private String city;
    private String zipCode;
    private LocalDate registrationDate;
    @JsonIgnore
    @OneToMany(mappedBy = "licensedMember", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<License> licenses;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name = "licensed_member_role",
            joinColumns = @JoinColumn(name="licensed_member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();

    private String club;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public String getGuardianName() {
        return guardianName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

     public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthdate() {
        return birthdate;
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

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Collection<License> getLicenses() {
        return licenses;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String getClub() {
        return club;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setId(Long id) {
        this.id = id;
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

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLicenses(Collection<License> licenses) {
        this.licenses = licenses;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setClub(String club) {
        this.club = club;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public LicensedMember() {
    }

}
