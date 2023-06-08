package com.appsfactory.calculation.Infrastructure;

import com.appsfactory.calculation.domain.model.CalculatedPremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatedPremiumRepository extends JpaRepository<CalculatedPremium, Long> {
}
