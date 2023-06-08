package com.appsfactory.carpolicy.application.api;

import com.appsfactory.carpolicy.application.controller.CarController;
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
@SpringBootTest("com.appsfactory.carpolicy.application.controller.CarApi")
class CarApiTest {
    @Autowired
    private CarApi carApi;

    @Test
    @Transactional
    void getAllCarManufacturer() {
        List<CarManufacturerDto> carManufacturerDtoList= carApi.getAllCarManufacturer();
        Assertions.assertTrue(carManufacturerDtoList.size()>0);
    }
}