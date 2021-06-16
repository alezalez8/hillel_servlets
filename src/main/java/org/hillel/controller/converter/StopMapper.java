package org.hillel.controller.converter;


import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Mapper
public interface StopMapper {


   /* @Mapping(source = "name", target = "stopName") // т.к. в source у меня не vehicleName а просто name, то это все для примера
    StopDto stopToStopDto(StopEntity stop);*/


   /* @Mapping(source = "stopName", target = "name") // т.к. в target у меня не vehicleName а просто name, то это все для примера
    StopEntity stopDtoToStop (StopDto dto);*/


    private Date parseDate(String date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String data = df.format(new Date());


    DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                    .withZone(ZoneId.systemDefault());


    @Mapping(target = "name", source = "commonInfo.name")
    @Mapping(target = "description", source = "commonInfo.description")
    StopDto stopToStopDto(StopEntity stop);

    default StopDto fullStopToDto(StopEntity stop) {
        StopDto stopDto = stopToStopDto(stop);
        stopDto.setLatitude(stop.getStopAddInfo().getLatitude());
        stopDto.setLongitude(stop.getStopAddInfo().getLongitude());
        return stopDto;
    }

    /*default String map(Instant value){
        return value != null ? FORMATTER.format(value) : null;
    }*/

    default String dateToString(Date date) {
        if (date != null) {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String data = df.format(date);
            return data;
        }
        return null;
    }


}
