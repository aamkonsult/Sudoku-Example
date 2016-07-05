package org.example.taxes.facade;

import org.example.taxes.model.TaxReport;

public class ClientWithFacade {

    public static void main(String[] args) {

        TaxReport lastMontReport = new TaxReport(40, 30, 20, 10);

        TaxReporterFacade taxFacade = new TaxReporterFacade();

        taxFacade.reportAll(lastMontReport);

        //        taxFacade.reportIncome(lastMontReport);
        //        taxFacade.reportSocial(lastMontReport);
        //        taxFacade.reportStatistics(lastMontReport);
    }

}
