package com.appsfactory.calculation.application.controller;

import com.appsfactory.calculation.domain.dto.UserParameterDto;

import com.appsfactory.calculation.domain.service.CalculationService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculation")
@ControllerAdvice
public class InsuranceCalculationController {
    @Autowired
    private CalculationService calculationService;


    public InsuranceCalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/calculationPremium")
    @CrossOrigin
    public String calculationPremium(@NotNull @RequestBody UserParameterDto userParameterDto) {

        return calculationService.CalculatePremium(userParameterDto.getAnnualDistance(), userParameterDto.getCarClass(), userParameterDto.getPostalCode());
    }
}

