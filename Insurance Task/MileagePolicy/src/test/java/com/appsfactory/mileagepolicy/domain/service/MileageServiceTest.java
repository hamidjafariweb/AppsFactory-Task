package com.appsfactory.mileagepolicy.domain.service;

import com.appsfactory.mileagepolicy.common.exception.exception.NotFoundEntityException;
import com.appsfactory.mileagepolicy.common.exception.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.mileagepolicy.domain.service.mileageService")
class MileageServiceTest {
    @Autowired
    private MileageService mileageService;

    @Test
    @Rollback
    void findFactorByMileage() throws UserException, NotFoundEntityException {
        Float mileageFactor = mileageService.findFactorByMileage(200001L);
        Assertions.assertEquals(mileageFactor, 315L);
    }
}