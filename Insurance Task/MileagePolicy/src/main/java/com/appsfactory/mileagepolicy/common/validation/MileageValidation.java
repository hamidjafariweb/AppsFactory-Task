package com.appsfactory.mileagepolicy.common.validation;

import org.springframework.stereotype.Component;

@Component
public  class MileageValidation {



    public  static   boolean  ValidateAnnualDistanceRange(Long annualDistance, Long annualDistanceMin,Long annualDistanceMax)
    {
        if(annualDistance>=annualDistanceMin && annualDistance<=annualDistanceMax)
        return true;
        return false;
    }
}
