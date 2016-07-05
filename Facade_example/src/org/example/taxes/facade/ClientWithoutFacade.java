package org.example.taxes.facade;

import org.example.taxes.model.SocialDepartmentReport;
import org.example.taxes.model.StatisticalDepartmentReport;
import org.example.taxes.model.TaxDepartmentReport;
import org.example.taxes.model.TaxReport;
import org.example.taxes.service.IncomeTaxReporter;
import org.example.taxes.service.SocialTaxReporter;
import org.example.taxes.service.StatisticalReporter;

public class ClientWithoutFacade {

    public static void main(String[] args) {

        TaxReport lastMontReport = new TaxReport(40, 30, 20, 10);


        TaxDepartmentReport taxReport = new TaxDepartmentReport(lastMontReport);
        taxReport.setBankReferenceNumber("12345");

        IncomeTaxReporter incomeReporter = new IncomeTaxReporter();
        do {
            System.out.println("Report To Tax Department ...");
        } while (!incomeReporter.reportToTaxDepartment(taxReport));


        SocialDepartmentReport scReport = new SocialDepartmentReport(lastMontReport);
        scReport.setDigitalSignature("Signature");

        SocialTaxReporter scReporter = new SocialTaxReporter();
        do {
            System.out.println("Report To Social Department ...");
        } while (!scReporter.reportToSocialDepartment(scReport));


        StatisticalDepartmentReport stReport = new StatisticalDepartmentReport(lastMontReport);
        stReport.setTimestamp("12 o'clock");

        StatisticalReporter stReporter = new StatisticalReporter();
        do {
            System.out.println("Report To Statistical Department ...");
        } while (!stReporter.reportToStatisticalDepartment(stReport));

    }

}
