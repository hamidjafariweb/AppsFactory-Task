package com.appsfactory.calculation.application.api;

import com.appsfactory.calculation.domain.dto.UserParameterDto;
import com.appsfactory.calculation.domain.service.CalculationService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculationApi")
@ControllerAdvice
public class InsuranceCalculationApi {
    @Autowired
    private CalculationService calculationService;

    public InsuranceCalculationApi(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculationPremium")
    public String calculationPremium(@NotNull @RequestBody  UserParameterDto userParameterDto) {
        return calculationService.CalculatePremium(userParameterDto.getAnnualDistance(),userParameterDto.getCarClass(),userParameterDto.getPostalCode());
    }

}

