package org.hillel.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StopDto {

    private Long id;
    private String  name;
    private String description;
    private String createDate;
    private String active;
    private Double longitude;
    private Double latitude;


}
