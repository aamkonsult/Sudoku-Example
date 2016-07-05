package org.example.taxes.service;

import org.example.taxes.model.SocialDepartmentReport;

public class SocialTaxReporter {

    public boolean reportToSocialDepartment(SocialDepartmentReport report) {
        return Math.random() < 0.7;
    }

}
