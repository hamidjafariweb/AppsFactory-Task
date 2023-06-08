package com.appsfactory.carpolicy.application.controller;

import com.appsfactory.carpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
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
@SpringBootTest("com.appsfactory.carpolicy.application.controller.CarController")
class CarControllerTest {
    @Autowired
    private CarController carController;

    @Test
    @Transactional
    void getCarFactor() throws NotFoundEntityException {
       Float carFactor= carController.GetCarFactor(1L);
       Assertions.assertEquals(carFactor,1.1F);
    }

    @Test
    @Transactional
    void getAllCarManufacturer() {
        List<CarManufacturerDto> carManufacturerDtoList= carController.getAllCarManufacturer();
        Assertions.assertTrue(carManufacturerDtoList.size()>0);
    }
}