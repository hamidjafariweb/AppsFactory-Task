package com.appsfactory.calculation.domain.model;

import javax.persistence.*;

@Entity
@Table
public class CalculatedPremium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long annualDistance;
    @Column(nullable = false)
    private Long carClass;
    @Column(nullable = false)
    private Long postalCode;
    @Column(nullable = false)
    private Float premium;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private java.util.Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Float getPermium() {
        return premium;
    }

    public void setPermium(Float permium) {
        this.premium = permium;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
}
