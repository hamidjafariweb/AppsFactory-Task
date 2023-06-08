package com.appsfactory.carpolicy.domain.service;

import com.appsfactory.carpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
import com.appsfactory.carpolicy.domain.mapper.CarManufacturerMapper;
import com.appsfactory.carpolicy.domain.model.CarClass;
import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import com.appsfactory.carpolicy.infrastructure.CarManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManufacturerService {
    @Autowired
    private static CarManufacturerRepository carManufacturerRepository;

    public CarManufacturerService(CarManufacturerRepository carManufacturerRepository) {
        this.carManufacturerRepository = carManufacturerRepository;
    }

    public List<CarManufacturer> getAllCarManufacturer() {
        List<CarManufacturer> carManufacturerList = carManufacturerRepository.findAll();
        return carManufacturerList;
    }

    public Float getFactorByCarClassId(Long carClassId) throws NotFoundEntityException {
        List<CarManufacturer> carManufacturerList = carManufacturerRepository.findAll();
        CarClass carClass = carManufacturerList.stream()
                .flatMap(t -> t.getCarClasses().stream())
                .filter(a -> a.getId() == carClassId).findAny().orElse(null);

        if (carClass != null)
            return carClass.getFactor();
        else
            throw new NotFoundEntityException("We Can Not Find Any Config For This Car Class");
    }

}
