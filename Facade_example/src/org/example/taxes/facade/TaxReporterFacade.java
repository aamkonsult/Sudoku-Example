package org.example.taxes.facade;

import org.example.taxes.model.SocialDepartmentReport;
import org.example.taxes.model.StatisticalDepartmentReport;
import org.example.taxes.model.TaxDepartmentReport;
import org.example.taxes.model.TaxReport;
import org.example.taxes.service.IncomeTaxReporter;
import org.example.taxes.service.SocialTaxReporter;
import org.example.taxes.service.StatisticalReporter;

public class TaxReporterFacade {

    public void reportIncome(TaxReport report) {
        TaxDepartmentReport taxReport = new TaxDepartmentReport(report);
        taxReport.setBankReferenceNumber("12345");

        IncomeTaxReporter incomeReporter = new IncomeTaxReporter();
        do {
            System.out.println("Report To Tax Department ...");
        } while (!incomeReporter.reportToTaxDepartment(taxReport));

    }


    public void reportSocial(TaxReport report) {
        SocialDepartmentReport scReport = new SocialDepartmentReport(report);
        scReport.setDigitalSignature("Signature");

        SocialTaxReporter scReporter = new SocialTaxReporter();
        do {
            System.out.println("Report To Social Department ...");
        } while (!scReporter.reportToSocialDepartment(scReport));

    }


    public void reportStatistics(TaxReport report) {
        StatisticalDepartmentReport stReport = new StatisticalDepartmentReport(report);
        stReport.setTimestamp("12 o'clock");

        StatisticalReporter stReporter = new StatisticalReporter();
        do {
            System.out.println("Report To Statistical Department ...");
        } while (!stReporter.reportToStatisticalDepartment(stReport));

    }

}
