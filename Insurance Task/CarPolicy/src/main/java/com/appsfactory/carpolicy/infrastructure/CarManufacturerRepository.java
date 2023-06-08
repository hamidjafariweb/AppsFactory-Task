package com.appsfactory.carpolicy.infrastructure;


import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarManufacturerRepository extends JpaRepository<CarManufacturer,Long> {

}
