package org.example.taxes.model;

public class TaxDepartmentReport {

    private TaxReport taxes;
    private String bankReferenceNumber;

    public TaxDepartmentReport(TaxReport taxes) {
        this.taxes = taxes;
    }

    public String getBankReferenceNumber() {
        return bankReferenceNumber;
    }

    public void setBankReferenceNumber(String bankReferenceNumber) {
        this.bankReferenceNumber = bankReferenceNumber;
    }

}
