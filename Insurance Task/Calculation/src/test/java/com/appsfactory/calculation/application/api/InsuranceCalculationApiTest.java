package com.appsfactory.calculation.application.api;

import com.appsfactory.calculation.domain.dto.UserParameterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.calculation.application.api.InsuranceCalculation.class")
class InsuranceCalculationApiTest {
    @Autowired
    private InsuranceCalculationApi insuranceCalculationApi;
    @Test
    void calculationPremium() {
        UserParameterDto userParameterDto=new UserParameterDto();
        userParameterDto.setAnnualDistance(1500L);
        userParameterDto.setCarClass(1L);
        userParameterDto.setPostalCode(555L);
        Float responseEntity = Float.valueOf(insuranceCalculationApi.calculationPremium(userParameterDto));
        Assertions.assertEquals(responseEntity,165F);
    }
}