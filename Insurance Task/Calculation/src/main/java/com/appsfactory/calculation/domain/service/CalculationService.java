package com.appsfactory.calculation.domain.service;

import com.appsfactory.calculation.domain.model.CalculatedPremium;
import com.appsfactory.calculation.Infrastructure.CalculatedPremiumRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class CalculationService {
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient client;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private CalculatedPremiumRepository calculatedPremiumRepository;

    public CalculationService(CalculatedPremiumRepository calculatedPremiumRepository) {
        this.calculatedPremiumRepository = calculatedPremiumRepository;
    }

    public String CalculatePremium(Long annualDistance,  Long carClass,  Long postalCode) {


        String premiumPrice = String.valueOf(getCarFactor(carClass) * getMileageFactor(annualDistance) * getRegionFactor(postalCode));
        CalculatedPremium calculatedPremium = new CalculatedPremium();
        calculatedPremium.setAnnualDistance(annualDistance);
        calculatedPremium.setPostalCode(postalCode);
        calculatedPremium.setCarClass(carClass);
        calculatedPremium.setPermium(Float.valueOf(premiumPrice));
        calculatedPremiumRepository.save(calculatedPremium);
        return premiumPrice;
    }

    private Float getCarFactor(Long carClass) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("carPolicy", false);
        String urlCarTypeFactor = instanceInfo.getHomePageUrl().concat("carPolicy/getCarFactor/" + carClass);
        ResponseEntity<Float> carTypeFactor = restTemplate.exchange(urlCarTypeFactor, HttpMethod.GET, null, Float.class);
        return carTypeFactor.getBody().floatValue();
    }

    private Float getRegionFactor(Long postalCode) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("regionPolicy", false);
        String urlRegionFactor = instanceInfo.getHomePageUrl().concat("regionPolicy/getRegionFactor/" + postalCode);
        ResponseEntity<Float> regionFactor = restTemplate.exchange(urlRegionFactor, HttpMethod.GET, null, Float.class);
        return regionFactor.getBody().floatValue();
    }

    private Float getMileageFactor(Long annualDistance) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("mileagePolicy", false);
        String urlMileageFactor = instanceInfo.getHomePageUrl().concat("mileagePolicy/getMileageFactor/" + annualDistance);
        ResponseEntity<Float> mileageFactor = restTemplate.exchange(urlMileageFactor, HttpMethod.GET, null, Float.class);
        return mileageFactor.getBody().floatValue();
    }
}

