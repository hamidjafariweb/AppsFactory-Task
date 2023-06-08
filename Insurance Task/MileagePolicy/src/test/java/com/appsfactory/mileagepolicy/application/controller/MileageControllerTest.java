package com.appsfactory.mileagepolicy.application.controller;

import com.appsfactory.mileagepolicy.common.exception.exception.NotFoundEntityException;
import com.appsfactory.mileagepolicy.common.exception.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.mileagepolicy.application.controller.MileageController")
class MileageControllerTest {
@Autowired
private MileageController mileageController;
    @Test
    void getMileageFactor() throws UserException, NotFoundEntityException {
        Float mileageFactor=  mileageController.GetMileageFactor(20001L);
        Assertions.assertEquals(mileageFactor, 315L);

    }
}