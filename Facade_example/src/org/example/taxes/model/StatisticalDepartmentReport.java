package org.example.taxes.model;

public class StatisticalDepartmentReport {

    private TaxReport taxes;
    private String timestamp;

    public StatisticalDepartmentReport(TaxReport taxes) {
        this.taxes = taxes;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
