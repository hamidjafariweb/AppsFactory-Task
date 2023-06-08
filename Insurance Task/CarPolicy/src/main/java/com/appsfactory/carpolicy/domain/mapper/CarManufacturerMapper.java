package com.appsfactory.carpolicy.domain.mapper;


import com.appsfactory.carpolicy.domain.dto.CarManufacturerDto;
import com.appsfactory.carpolicy.domain.model.CarManufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarManufacturerMapper {
    CarManufacturerMapper INSTANCE = Mappers.getMapper(CarManufacturerMapper.class);

    CarManufacturerDto carManufacturerToCarManufacturerDto(CarManufacturer carManufacturer);
}
