package org.hillel.controller.dto;


import lombok.Getter;
import lombok.Setter;
import org.hillel.persistence.entity.util.YesNoConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.util.Date;

@Getter
@Setter
public class StopDto {

    private Long id;
    private String  name;
    private String createDate;
    private String active;
    private String description;
    private Double longitude;
    private Double latitude;
}
