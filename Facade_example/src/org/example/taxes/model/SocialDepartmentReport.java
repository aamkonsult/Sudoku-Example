package org.example.taxes.model;

public class SocialDepartmentReport {

    private TaxReport taxes;
    private String digitalSignature;

    public SocialDepartmentReport(TaxReport taxes) {
        this.taxes = taxes;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }

}
