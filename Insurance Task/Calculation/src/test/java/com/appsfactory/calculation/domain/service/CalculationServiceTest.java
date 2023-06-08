package com.appsfactory.calculation.domain.service;

import com.appsfactory.calculation.domain.dto.UserParameterDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("com.appsfactory.calculation.domain.service.CalculationService")
class CalculationServiceTest {
@Autowired
private CalculationService calculationService;
    @Test
    void calculatePremium() {
    Float premiumPrice=Float.valueOf(calculationService.CalculatePremium(1000L,1L,555L));
    Assertions.assertEquals(premiumPrice,165F);

    }
}