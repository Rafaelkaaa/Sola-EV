package com.example.solaev.dto.charging_station;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStationCreateDto {
    private String title;
    private String description;
    private CoordinatesDto coordinates;
    private boolean isPublic;
    private List<ChargingConnectorDto> chargingConnectors;
}
