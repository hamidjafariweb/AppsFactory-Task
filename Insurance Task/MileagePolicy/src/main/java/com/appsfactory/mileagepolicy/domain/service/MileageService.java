package com.appsfactory.mileagepolicy.domain.service;

import com.appsfactory.mileagepolicy.common.exception.exception.NotFoundEntityException;
import com.appsfactory.mileagepolicy.common.exception.exception.UserException;
import com.appsfactory.mileagepolicy.domain.model.Mileage;
import com.appsfactory.mileagepolicy.common.validation.MileageValidation;
import com.appsfactory.mileagepolicy.infrastructure.MileageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MileageService {
    @Autowired
    private static MileageRepository mileageRepository;
    @Value("${mileage.annualDistance.min}")
    private int annualDistanceMin;
    @Value("${mileage.annualDistance.max}")
    private int annualDistanceMax;


    public MileageService(MileageRepository mileageRepository) {
        this.mileageRepository = mileageRepository;
    }


    public Float findFactorByMileage(Long annualDistance) throws NotFoundEntityException, UserException {
        if (!MileageValidation.ValidateAnnualDistanceRange(annualDistance,Long.valueOf( annualDistanceMin),Long.valueOf(annualDistanceMax)))
            throw new UserException("Out of Range Annual Distance");
        List<Mileage> mileagesList = mileageRepository.findAll();
        Optional<Mileage> mileage = mileagesList.stream().filter(t -> t.getMinRange() <= annualDistance && t.getMaxRange() >= annualDistance).findFirst();
        if (mileage.isPresent())
            return mileage.get().getFactor();
        else
            throw new NotFoundEntityException("We Can Not Find Any Config For This Annual Distance");


    }


}
