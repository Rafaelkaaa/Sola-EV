package com.example.solaev.util;

import com.example.solaev.dto.AddressDto;
import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.dto.charging_station.ChargingStationRequestDto;
import com.example.solaev.model.*;

import java.util.Collections;
import java.util.UUID;

public class ModelUtils {
    public static double getLatitude() {
        return 1.0;
    }

    public static double getLongitude() {
        return 1.0;
    }

    public static CoordinatesDto getCoordinatesDto() {
        return CoordinatesDto.builder()
                .id("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc")
                .latitude(getLatitude())
                .longitude(getLongitude())
                .build();
    }

    public static Coordinates getCoordinates(){
        return Coordinates.builder()
                .id(UUID.fromString("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc"))
                .latitude(getLatitude())
                .longitude(getLongitude())
                .build();
    }

    public static AddressDto getAddressDto() {
        return AddressDto.builder()
                .id("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc")
                .houseNumber("houseNumber")
                .street("street")
                .city("city")
                .region("region")
                .country("country")
                .postCode("postCode")
                .build();
    }

    public static Address getAddress() {
        return Address.builder()
                .id(UUID.fromString("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc"))
                .houseNumber("houseNumber")
                .street("street")
                .city("city")
                .region("region")
                .country("country")
                .postCode("postCode").build();
    }

    public static ChargingConnectorDto getChargingConnectorDto() {
        return ChargingConnectorDto.builder()
                .id("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc")
                .type(ChargingConnectorType.Type1.toString())
                .maxKw(50)
                .build();
    }

    public static ChargingConnector getChargingConnector() {
        return ChargingConnector.builder()
                .id(UUID.fromString("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc"))
                .type(ChargingConnectorType.Type1)
                .maxKw(50)
                .build();
    }

    public static ChargingStationDto getChargingStationDto(){
        return ChargingStationDto.builder()
                .id("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc")
                .title("title")
                .description("description")
                .isPublic(true)
                .chargingConnectors(Collections.singletonList(getChargingConnectorDto()))
                .address(getAddressDto())
                .coordinates(getCoordinatesDto())
                .build();
    }

    public static ChargingStation getChargingStation(){
        return ChargingStation.builder()
                .id(UUID.fromString("e97b4ad8-8ea2-46e0-becf-7c793e3f92fc"))
                .title("title")
                .description("description")
                .isPublic(true)
                .chargingConnectors(Collections.singletonList(getChargingConnector()))
                .address(getAddress())
                .coordinates(getCoordinates())
                .build();
    }

    public static ChargingStationRequestDto getChargingStationRequestDto(){
        return ChargingStationRequestDto.builder()
                .title("title")
                .description("description")
                .isPublic(true)
                .chargingConnectors(Collections.singletonList(getChargingConnectorDto()))
                .coordinates(getCoordinatesDto())
                .build();
    }
}
