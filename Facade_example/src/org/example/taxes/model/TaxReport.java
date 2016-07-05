package org.example.taxes.model;

public class TaxReport {

    private int incomeTax;
    private int healthInsuranceTax;
    private int unemploymentInsuranseTax;
    private int otherTaxes;

    public TaxReport(int income, int healt, int unemployment, int others) {
        this.incomeTax = income;
        this.healthInsuranceTax = healt;
        this.unemploymentInsuranseTax = unemployment;
        this.otherTaxes = others;
    }

    @Override
    public String toString() {
        return "Income Tax: " + incomeTax + ", Health Insurance: " + healthInsuranceTax + ", Unemployment Insurance: " + unemploymentInsuranseTax;
    }

}
