package com.ludijf.pongyclub.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.dto.LicensePaymentDateDTO;
import com.ludijf.pongyclub.entity.dto.LicenseStartDateDTO;
import com.ludijf.pongyclub.repository.LicenseDao;
import com.ludijf.pongyclub.service.impl.LicensesManagementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

class LicensesManagementServiceImplTest {

    @Mock
    private LicenseDao licenseDao;

    @InjectMocks
    private LicensesManagementServiceImpl licensesManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllLicensesMock() {
        License license1 = new License();
        License license2 = new License();

        when(licenseDao.findAll()).thenReturn(List.of(license1, license2));

        List<License> licenses = licensesManagementService.getAllLicenses();

        assertNotNull(licenses);
        assertEquals(2, licenses.size());
    }

    @Test
    void getActiveLicensesMock() {
        LocalDate today = LocalDate.now();
        License license1 = new License();
        license1.setEndDate(today.plusDays(1));
        License license2 = new License();
        license2.setEndDate(today.plusDays(2));

        when(licenseDao.findByEndDateAfter(today)).thenReturn(List.of(license1, license2));

        List<License> licenses = licensesManagementService.getActiveLicenses();

        assertNotNull(licenses);
        assertEquals(2, licenses.size());
        assertTrue(licenses.get(0).getEndDate().isAfter(today));
        assertTrue(licenses.get(1).getEndDate().isAfter(today));
    }

    @Test
    void getUnpaidLicenseMock() {
        License license1 = new License();
        license1.setPaymentDate(null);
        License license2 = new License();
        license2.setPaymentDate(null);

        when(licenseDao.findByPaymentDateIsNull()).thenReturn(List.of(license1, license2));

        List<License> licenses = licensesManagementService.getUnpaidLicenses();

        assertNotNull(licenses);
        assertEquals(2, licenses.size());
        assertNull(licenses.get(0).getPaymentDate());
        assertNull(licenses.get(1).getPaymentDate());
    }

    @Test
    void getUnstartedLicensesMock() {
        License license1 = new License();
        license1.setStartDate(null);
        License license2 = new License();
        license2.setStartDate(null);

        when(licenseDao.findByStartDateIsNull()).thenReturn(List.of(license1, license2));

        List<License> licenses = licensesManagementService.getUnstartedLicenses();

        assertNotNull(licenses);
        assertEquals(2, licenses.size());
        assertNull(licenses.get(0).getStartDate());
        assertNull(licenses.get(1).getStartDate());
    }

    @Test
    void setPaymentDateMock() {
        LicensePaymentDateDTO dto = new LicensePaymentDateDTO();
        dto.setLicenseId(1L);
        dto.setPaymentDate(LocalDate.now());

        License license = new License();
        license.setId(1L);

        when(licenseDao.findById(1L)).thenReturn(Optional.of(license));
        when(licenseDao.save(any(License.class))).thenReturn(license);

        License updatedLicense = licensesManagementService.setPaymentDate(dto);

        assertEquals(dto.getPaymentDate(), updatedLicense.getPaymentDate());
        verify(licenseDao).findById(1L);
        verify(licenseDao).save(license);
    }

    @Test
    void setStartDateMock() {
        LicenseStartDateDTO dto = new LicenseStartDateDTO();
        dto.setLicenseId(1L);
        dto.setStartDate(LocalDate.now());

        License license = new License();
        license.setId(1L);

        when(licenseDao.findById(1L)).thenReturn(Optional.of(license));
        when(licenseDao.save(any(License.class))).thenReturn(license);

        License updatedLicense = licensesManagementService.setStartDate(dto);

        assertEquals(dto.getStartDate(), updatedLicense.getStartDate());
        assertNotNull(updatedLicense.getEndDate());
        verify(licenseDao).findById(1L);
        verify(licenseDao).save(license);
    }

}

