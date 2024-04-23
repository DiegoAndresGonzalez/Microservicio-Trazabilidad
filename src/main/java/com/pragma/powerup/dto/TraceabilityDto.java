package com.pragma.powerup.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TraceabilityDto {

    private Long id;
    private Long orderId;
    private Long clientId;
    private Long chefId;
    private Date date;
    private String lastStatus;
    private String newStatus;
    private String clientEmail;
    private String chefEmail;

}