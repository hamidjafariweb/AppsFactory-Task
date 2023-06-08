package com.appsfactory.calculation.application.controller;

import com.appsfactory.calculation.domain.dto.UserParameterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.calculation.application.controller.InsuranceCalculation.class")
class InsuranceCalculationControllerTest {
    @Autowired
    private InsuranceCalculationController insuranceCalculationController;
    @Test
    @Rollback
    @Transactional
    void calculationPremium()  {
        UserParameterDto userParameterDto=new UserParameterDto();
        userParameterDto.setAnnualDistance(1000L);
        userParameterDto.setCarClass(1L);
        userParameterDto.setPostalCode(555L);
     Float responseEntity = Float.valueOf(insuranceCalculationController.calculationPremium(userParameterDto));
        Assertions.assertEquals(responseEntity,165F);


    }
}
