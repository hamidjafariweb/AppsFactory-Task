package com.appsfactory.calculation.domain.dto;

public class UserParameterDto {
    private Long annualDistance;
    private Long carClass;
    private Long postalCode;

    public Long getAnnualDistance() {
        return annualDistance;
    }

    public void setAnnualDistance(Long annualDistance) {
        this.annualDistance = annualDistance;
    }

    public Long getCarClass() {
        return carClass;
    }

    public void setCarClass(Long carClass) {
        this.carClass = carClass;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }
}
