package org.hillel.controller.converter;


import org.hillel.controller.dto.StopDto;
import org.hillel.persistence.entity.StopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

@Mapper
public interface StopMapper {




    @Mapping(target = "name", source = "commonInfo.name")
    @Mapping(target = "description", source = "commonInfo.description")
    StopDto stopToStopDto(StopEntity stop);



    default StopDto fullStopToDto(StopEntity stop) {
        StopDto stopDto = stopToStopDto(stop);
        stopDto.setLatitude(stop.getStopAddInfo().getLatitude());
        stopDto.setLongitude(stop.getStopAddInfo().getLongitude());
        return stopDto;
    }



    default String dateToString(Date date) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String data = df.format(date);
            return data;
        }
        return null;
    }


}
