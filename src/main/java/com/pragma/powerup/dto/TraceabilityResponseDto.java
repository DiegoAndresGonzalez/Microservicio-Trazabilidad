package com.pragma.powerup.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TraceabilityResponseDto {

    private Date date;
    private String lastStatus;
    private String newStatus;

}
