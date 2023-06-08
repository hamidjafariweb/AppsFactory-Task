package com.appsfactory.regionpolicy.domain.service;


import com.appsfactory.regionpolicy.common.exception.AdminException;
import com.appsfactory.regionpolicy.common.exception.NotFoundEntityException;
import com.appsfactory.regionpolicy.domain.model.CalculationPriority;
import com.appsfactory.regionpolicy.domain.model.Location;
import com.appsfactory.regionpolicy.infrastructure.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {


    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CalculationPriority calculationPriority;

    public StateService(StateRepository stateRepository, CalculationPriority calculationPriority) {
        this.stateRepository = stateRepository;
        this.calculationPriority = calculationPriority;

    }

    public Float findFactorByPostalCode(Long postalCode) throws NotFoundEntityException, AdminException {
        Location location = stateRepository.findAll().stream().flatMap(a -> a.getCounties().stream()).flatMap(b -> b.getCities().stream()).flatMap(c -> c.getLocations().stream()).filter(d -> d.getPostalCode() == postalCode.longValue()).findAny().orElse(null);
        if (location != null) {
            Float factorCounty = location.getCity().getCounty().getFactor();
            Float factorState = location.getCity().getCounty().getState().getFactor();
            if (calculationPriority.getPriority().equals("county"))
                return factorCounty;
            else if (calculationPriority.getPriority().equals("state"))
                return factorState;
            else
                throw new AdminException("There is no any Config for PostalCode Configuration");

        } else
            throw new NotFoundEntityException("We Can Not Find Any Config For This PostalCode:" + postalCode);


    }


}
