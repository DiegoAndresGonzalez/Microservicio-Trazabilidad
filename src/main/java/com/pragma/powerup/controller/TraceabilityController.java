package com.pragma.powerup.controller;

import com.pragma.powerup.adapter.TraceabilityAdapter;
import com.pragma.powerup.dto.TraceabilityDto;
import com.pragma.powerup.dto.TraceabilityResponseDto;
import com.pragma.powerup.mapper.TraceabilityMapper;
import com.pragma.powerup.model.OrderStatusLog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class TraceabilityController {

    private final TraceabilityMapper traceabilityMapper;
    private final TraceabilityAdapter traceabilityAdapter;

    @PostMapping
    public ResponseEntity<OrderStatusLog> saveLog(@RequestBody TraceabilityDto traceabilityDto){
        OrderStatusLog savedLog = traceabilityAdapter.
                changeOrderStatus(traceabilityDto.getOrderId(),traceabilityDto.getClientId(), traceabilityDto.getChefId(),
                        traceabilityDto.getLastStatus(), traceabilityDto.getNewStatus(), traceabilityDto.getDate(),traceabilityDto.getClientEmail(),traceabilityDto.getChefEmail());
        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    @GetMapping("/client")
    public ResponseEntity<List<TraceabilityResponseDto>> findLog(@RequestHeader("Authorization") String token){
        List<OrderStatusLog> clientLogs = traceabilityAdapter.getClientLogs(token);
        List<TraceabilityResponseDto> responseDto = traceabilityMapper.toResponse(clientLogs);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}