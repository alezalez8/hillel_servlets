package org.hillel.controller.converter;


import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StopMapper {


   /* @Mapping(source = "name", target = "stopName") // т.к. в source у меня не vehicleName а просто name, то это все для примера
    StopDto stopToStopDto(StopEntity stop);*/


   /* @Mapping(source = "stopName", target = "name") // т.к. в target у меня не vehicleName а просто name, то это все для примера
    StopEntity stopDtoToStop (StopDto dto);*/


}
