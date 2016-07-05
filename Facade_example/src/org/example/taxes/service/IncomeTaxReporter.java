package org.example.taxes.service;

import org.example.taxes.model.TaxDepartmentReport;

public class IncomeTaxReporter {

    public boolean reportToTaxDepartment(TaxDepartmentReport report) {
        return Math.random() < 0.9;
    }

}
