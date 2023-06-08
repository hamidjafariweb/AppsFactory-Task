package com.appsfactory.regionpolicy.domain.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CalculationPriority {
    @Value("${calculation.priority}")
    private String priority;

    public String getPriority() {
        return priority;
    }
}
