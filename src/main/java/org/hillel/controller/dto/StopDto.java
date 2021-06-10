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
    private String stopName;
    private Date createDate;
    private boolean active;
}
