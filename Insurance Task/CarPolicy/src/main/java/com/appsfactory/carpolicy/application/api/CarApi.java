package com.appsfactory.carpolicy.application.api;

import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
import com.appsfactory.carpolicy.domain.mapper.CarManufacturerMapper;
import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import com.appsfactory.carpolicy.domain.service.CarManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carApi")
public class CarApi {
    @Autowired
    private CarManufacturerService carManufacturerService;

    public CarApi() {
        this.carManufacturerService = carManufacturerService;

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

