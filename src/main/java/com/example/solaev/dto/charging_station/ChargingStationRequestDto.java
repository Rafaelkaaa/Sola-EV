package com.example.solaev.dto.charging_station;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStationRequestDto {
    private String title;
    private String description;
    private CoordinatesDto coordinates;
    private boolean isPublic;
    private List<ChargingConnectorDto> chargingConnectors;
}
