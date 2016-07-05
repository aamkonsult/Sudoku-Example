package org.example.taxes.service;

import org.example.taxes.model.StatisticalDepartmentReport;

public class StatisticalReporter {

    public boolean reportToStatisticalDepartment(StatisticalDepartmentReport report) {
        return Math.random() < 0.5;
    }
}
