package com.appsfactory.regionpolicy.application.controller;

import com.appsfactory.regionpolicy.common.exception.AdminException;
import com.appsfactory.regionpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.regionpolicy.domain.service.StateService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/regionPolicy")
public class StateController {
    @Autowired
    private StateService stateService;

    @GetMapping("/getRegionFactor/{postalCode}")
    public Float GetRegionFactor(@PathVariable @NotNull Long postalCode) throws IOException, NotFoundEntityException, AdminException {
       return stateService.findFactorByPostalCode(postalCode);
    }

}
