package com.appsfactory.carpolicy.domain.dto;

import java.util.List;

public class CarManufacturerDto {
    private Long id;
    private String name;
    private List<com.appsfactory.carpolicy.domain.dto.CarClassDto> carClasses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.appsfactory.carpolicy.domain.dto.CarClassDto> getCarClasses() {
        return carClasses;
    }

    public void setCarClasses(List<com.appsfactory.carpolicy.domain.dto.CarClassDto> carClasses) {
        this.carClasses = carClasses;
    }
}
