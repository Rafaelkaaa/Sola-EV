package com.example.solaev.dto.charging_station;

import com.example.solaev.dto.AddressDto;
import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.ChargingStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStationDto {
    private String id;
    private String title;
    private String description;
    private AddressDto address;
    private CoordinatesDto coordinates;
    private boolean isPublic;
    private List<ChargingConnectorDto> chargingConnectors;

    public ChargingStationDto(ChargingStation chargingStation) {
        this.id = chargingStation.getId().toString();
        this.title = chargingStation.getTitle();
        this.description = chargingStation.getDescription();
        if (chargingStation.getAddress() != null) {
            this.address = new AddressDto(chargingStation.getAddress());
        }
        this.coordinates = new CoordinatesDto(chargingStation.getCoordinates());
        this.isPublic = chargingStation.isPublic();
        this.chargingConnectors = chargingStation.getChargingConnectors()
                .stream()
                .map(ChargingConnectorDto::new)
                .toList();
    }
}
