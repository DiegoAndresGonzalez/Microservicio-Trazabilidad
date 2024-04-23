package com.pragma.powerup.mapper;

import com.pragma.powerup.dto.TraceabilityResponseDto;
import com.pragma.powerup.model.OrderStatusLog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TraceabilityMapper {

    List<TraceabilityResponseDto> toResponse(List<OrderStatusLog> statusLog);

}