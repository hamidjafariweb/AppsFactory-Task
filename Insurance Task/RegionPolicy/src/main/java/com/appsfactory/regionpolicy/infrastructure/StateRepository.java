package com.appsfactory.regionpolicy.infrastructure;


import com.appsfactory.regionpolicy.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StateRepository extends JpaRepository<State,Long> {
    List<State> findByName(String x);

}
