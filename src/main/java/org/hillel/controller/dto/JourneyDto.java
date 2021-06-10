package org.hillel.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JourneyDto {
    private Long id;
    private String stationFrom;
    private String stationTo;
    private Date departure;
    private Date arrival;
}



