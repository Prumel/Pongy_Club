package com.ludijf.pongyclub.controller;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.dto.LicensePaymentDateDTO;
import com.ludijf.pongyclub.entity.dto.LicenseStartDateDTO;
import com.ludijf.pongyclub.service.LicensesManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/licenses")
@CrossOrigin("${front.url}")
public class LicensesManagementController {

    private LicensesManagementService licensesManagementService;

    public LicensesManagementController(LicensesManagementService licensesManagementService) {
        this.licensesManagementService = licensesManagementService;
    }

    @GetMapping("/all-licenses")
    public List<License> getAllLicenses() {
        return licensesManagementService.getAllLicenses();
    }

    @GetMapping("/active-licenses")
    public List<License> getActiveLicenses() {
        return licensesManagementService.getActiveLicenses();
    }

    @GetMapping("/unpaid-licenses")
    public List<License> getUnpaidLicenses() {
        return licensesManagementService.getUnpaidLicenses();
    }

    @GetMapping("/unstarted-licenses")
    public List<License> getUnstartedLicenses() {
        return licensesManagementService.getUnstartedLicenses();
    }

    @PutMapping("/start-date")
    public License setStartDate(@RequestBody LicenseStartDateDTO licenseStartDateDTO) {
        return licensesManagementService.setStartDate(licenseStartDateDTO);
    }

    @PutMapping("/payment-date")
    public License setPaymentDate(@RequestBody LicensePaymentDateDTO licensePaymentDateDTO) {
        return licensesManagementService.setPaymentDate(licensePaymentDateDTO);
    }
}
