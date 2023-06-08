package com.appsfactory.carpolicy.application.controller;


import com.appsfactory.carpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
import com.appsfactory.carpolicy.domain.mapper.CarManufacturerMapper;
import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import com.appsfactory.carpolicy.domain.service.CarManufacturerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carPolicy")

public class CarController {
    @Autowired
    private CarManufacturerService carManufacturerService;


    public CarController(CarManufacturerService carManufacturerService) {
        this.carManufacturerService = carManufacturerService;
    }

    @GetMapping("/getCarFactor/{carCode}")
    public Float GetCarFactor(@PathVariable @NotNull Long carCode) throws NotFoundEntityException {
        return carManufacturerService.getFactorByCarClassId(carCode);
    }

    @GetMapping("/getAllCarManufacturer")
    public List<CarManufacturerDto> getAllCarManufacturer() {

        List<CarManufacturer> carManufacturerList = carManufacturerService.getAllCarManufacturer();
        List<CarManufacturerDto> carManufacturerDtoList = new ArrayList<>();
        for (CarManufacturer carManufacturer : carManufacturerList) {
            CarManufacturerDto carDto = CarManufacturerMapper.INSTANCE.carManufacturerToCarManufacturerDto(carManufacturer);
            carManufacturerDtoList.add(carDto);

        }
        return carManufacturerDtoList;
    }
}

