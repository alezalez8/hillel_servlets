package org.hillel.service;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class InputDataJourney {

    private String stationFrom;
    private String stationTo;
    private Date departure;
    private Date arrival;
}
