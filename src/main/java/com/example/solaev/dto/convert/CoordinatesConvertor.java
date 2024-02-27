package com.example.solaev.dto.convert;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.Coordinates;

import java.util.UUID;

public class CoordinatesConvertor {
    public static Coordinates convertToEntity(CoordinatesDto coordinatesDto) {
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
