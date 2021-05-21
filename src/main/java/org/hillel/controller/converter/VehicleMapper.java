package org.hillel.controller.converter;


import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleMapper {


    @Mapping(source = "name", target = "name") // т.к. в source у меня не vehicleName а просто name, то это все для примера
    VehicleDto vehicleToVehicleDto(VehicleEntity vehicle);

    @Mapping(source = "name", target = "name") // т.к. в target у меня не vehicleName а просто name, то это все для примера
    VehicleEntity vehicleDtoToVehicle(VehicleDto dto);
}
