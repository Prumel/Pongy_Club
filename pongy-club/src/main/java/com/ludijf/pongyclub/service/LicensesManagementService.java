package com.ludijf.pongyclub.service;

import com.ludijf.pongyclub.entity.License;
import com.ludijf.pongyclub.entity.dto.LicensePaymentDateDTO;
import com.ludijf.pongyclub.entity.dto.LicenseStartDateDTO;

import java.util.List;

/**
 * Service interface for managing licenses.
 */
public interface LicensesManagementService {

    /**
     * Retrieves all licenses.
     *
     * @return a list of all licenses.
     */
    public List<License> getAllLicenses();

    /**
     * Retrieves all active licenses.
     *
     * @return a list of all active licenses - for which the end date is after the current date / has not expired.
     */
    public List<License> getActiveLicenses();

    /**
     * Retrieves all licenses which are not registered as paid yet.
     *
     * @return a list of all unpaid licenses.
     */
    public List<License> getUnpaidLicenses();

    /**
     * Retrieves all licenses for which the start date is not set yet.
     *
     * @return a list of all unstarted licenses.
     */
    public List<License> getUnstartedLicenses();

    /**
     * Sets the payment date of a license.
     * @param licensePaymentDateDTO the license to update.
     * @return the updated license.
     */
     License setPaymentDate(LicensePaymentDateDTO licensePaymentDateDTO);

    /**
     * Sets the start date of a license
     * @param licenseStartDateDTO the license to update.
     * @return the updated license with a start date.
     */
     License setStartDate(LicenseStartDateDTO licenseStartDateDTO);

    /**
     * Sets the end date of a license to the next month of July.
     *
     * @param licenseId the ID of the license to update.
     * @return the updated license.
     */


}