//package com.appsfactory.policy.controller;
//import com.appsfactory.policy.exception.NotFoundMilageException;
//import com.appsfactory.policy.exception.UserException;
//import com.appsfactory.policy.service.CarManufacturerService;
//import com.appsfactory.policy.service.MileageService;
//import com.appsfactory.policy.service.StateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/policy")
//@Validated
//public class MileageController {
//	@Autowired
//	private MileageService mileageService;
//	public MileageController(MileageService mileageService, CarManufacturerService carManufacturerService,StateService stateService) {
//		this.mileageService = mileageService;
//	}
//
//	@GetMapping("/getMileageFactor/{anuualDistance}")
//	    public Float GetMileageFactor( @PathVariable   Long annualDistance) throws NotFoundMilageException,UserException {
//			Float mileageFactor=mileageService.findFactorByMileage(annualDistance);
//			return mileageFactor;
//	    }
//
//
//}

package com.appsfactory.mileagepolicy.application.controller;

import com.appsfactory.mileagepolicy.common.exception.exception.NotFoundEntityException;
import com.appsfactory.mileagepolicy.common.exception.exception.UserException;
import com.appsfactory.mileagepolicy.domain.service.MileageService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mileagePolicy")
public class MileageController {
    @Autowired
    private MileageService mileageService;

    public MileageController(MileageService mileageService) {
        this.mileageService = mileageService;

    }

    @GetMapping("/getMileageFactor/{annualDistance}")
    public Float GetMileageFactor(@PathVariable @NotNull Long annualDistance) throws NotFoundEntityException, UserException {
        Float mileageFactor = mileageService.findFactorByMileage(annualDistance);
        return mileageFactor;
    }


}

