package com.example.solaev.util;

import com.example.solaev.dto.AddressDto;
import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.charging_station.ChargingStationRequestDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.model.*;

import java.util.Arrays;
import java.util.UUID;

public class ConvertToEntityUtils {
    public static Address convert(AddressDto addressDto){
        if (addressDto == null){
            return null;
        }
        Address address = Address.builder()
                .houseNumber(addressDto.getHouseNumber())
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .region(addressDto.getRegion())
                .country(addressDto.getCountry())
                .postCode(addressDto.getPostCode())
                .build();
        if (addressDto.getId() != null){
            address.setId(UUID.fromString(addressDto.getId()));
        }
        return address;
    }

    public static ChargingConnector convert(ChargingConnectorDto chargingConnectorDto) {
        ChargingConnector chargingConnector;
        try {
            chargingConnector = ChargingConnector.builder()
                    .type(ChargingConnectorType.valueOf(chargingConnectorDto.getType()))
                    .maxKw(chargingConnectorDto.getMaxKw())
                    .build();
        }catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Allowable values for the connector: " + Arrays.toString(ChargingConnectorType.values()));
        }
        if (chargingConnectorDto.getId() != null){
            chargingConnector.setId(UUID.fromString(chargingConnectorDto.getId()));
        }
        return chargingConnector;
    }

    public static ChargingStation convert(ChargingStationRequestDto chargingStationDto) {
        return ChargingStation.builder()
                .title(chargingStationDto.getTitle())
                .description(chargingStationDto.getDescription())
                .coordinates(convert(chargingStationDto.getCoordinates()))
                .isPublic(chargingStationDto.isPublic())
                .chargingConnectors(chargingStationDto.getChargingConnectors()
                        .stream()
                        .map(ConvertToEntityUtils::convert)
                        .toList())
                .build();
    }

    public static Coordinates convert(CoordinatesDto coordinatesDto) {
        Coordinates coordinates = Coordinates.builder()
                .longitude(coordinatesDto.getLongitude())
                .latitude(coordinatesDto.getLatitude())
                .build();
        if (coordinatesDto.getId() != null) {
            coordinates.setId(UUID.fromString(coordinatesDto.getId()));
        }
        return coordinates;
    }
}
