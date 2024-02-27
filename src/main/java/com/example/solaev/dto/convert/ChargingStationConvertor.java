package com.example.solaev.dto.convert;

import com.example.solaev.dto.charging_station.ChargingStationCreateDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.model.ChargingStation;

import java.util.UUID;

public class ChargingStationConvertor {
    public static ChargingStation convertToEntity(ChargingStationDto chargingStationDto) {
        ChargingStation chargingStation = ChargingStation.builder()
                .title(chargingStationDto.getTitle())
                .description(chargingStationDto.getDescription())
                .address(AddressConvertor.convertToEntity(chargingStationDto.getAddress()))
                .coordinates(CoordinatesConvertor.convertToEntity(chargingStationDto.getCoordinates()))
                .isPublic(chargingStationDto.isPublic())
                .chargingConnectors(chargingStationDto.getChargingConnectors()
                        .stream()
                        .map(ChargingConnectorConvertor::convertToEntity)
                        .toList())
                .build();
        if (chargingStationDto.getId() != null) {
            chargingStation.setId(UUID.fromString(chargingStationDto.getId()));
        }
        return chargingStation;
    }

    public static ChargingStation convertToEntity(ChargingStationCreateDto chargingStationDto) {
        return ChargingStation.builder()
                .title(chargingStationDto.getTitle())
                .description(chargingStationDto.getDescription())
                .coordinates(CoordinatesConvertor.convertToEntity(chargingStationDto.getCoordinates()))
                .isPublic(chargingStationDto.isPublic())
                .chargingConnectors(chargingStationDto.getChargingConnectors()
                        .stream()
                        .map(ChargingConnectorConvertor::convertToEntity)
                        .toList())
                .build();
    }
}
