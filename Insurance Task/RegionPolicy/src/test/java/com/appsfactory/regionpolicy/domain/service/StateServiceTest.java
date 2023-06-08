package com.appsfactory.regionpolicy.domain.service;

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

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.regionpolicy.domain.service.StateService.class")
class StateServiceTest {
@Autowired
private StateService stateService;
    @Test
    @Transactional
    void findFactorByPostalCode() throws AdminException, NotFoundEntityException {
        Float stateFactor=stateService.findFactorByPostalCode(555L);
        Assertions.assertEquals(stateFactor,1.5F);

    }
}