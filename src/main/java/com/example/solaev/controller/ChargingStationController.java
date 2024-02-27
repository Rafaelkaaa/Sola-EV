package com.example.solaev.controller;

import com.example.solaev.dto.charging_station.ChargingStationCreateDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.service.ChargingStationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/charging_station")
@AllArgsConstructor
public class ChargingStationController {

    private ChargingStationService chargingStationService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    @ApiResponse(responseCode = "201", description = "Charging station created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request")

    public ResponseEntity<ChargingStationDto> saveChargingStation(@RequestBody ChargingStationCreateDto chargingStationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chargingStationService.crete(chargingStationDto));
    }
}
