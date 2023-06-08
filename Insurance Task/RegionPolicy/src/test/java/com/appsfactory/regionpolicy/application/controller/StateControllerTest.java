package com.appsfactory.regionpolicy.application.controller;

import com.appsfactory.regionpolicy.common.exception.AdminException;
import com.appsfactory.regionpolicy.common.exception.NotFoundEntityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.regionpolicy.application.controller.StateController.class")
class StateControllerTest {
    @Autowired
private StateController stateController;
    @Test
    @Transactional
    void getRegionFactor() throws AdminException, IOException, NotFoundEntityException {
       Float stateFactor= stateController.GetRegionFactor(555L);
        Assertions.assertEquals(stateFactor, 1.5F);

    }
}