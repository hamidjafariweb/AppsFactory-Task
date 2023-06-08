package com.appsfactory.carpolicy.domain.service;

import com.appsfactory.carpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.carpolicy.domain.servic.CarManufacturerService")
class CarManufacturerServiceTest {
    @Autowired
    private CarManufacturerService carManufacturerService;

    @Test
    @Transactional
    void getAllCarManufacturer() {
        List<CarManufacturer> carManufacturerList= carManufacturerService.getAllCarManufacturer();
        Assertions.assertTrue(carManufacturerList.size()>0);
    }

    @Test
    @Transactional
    void getFactorByCarClassId() throws NotFoundEntityException {
        Float carFactor= carManufacturerService.getFactorByCarClassId(1L);
        Assertions.assertEquals(carFactor,1.1F);
    }
}




