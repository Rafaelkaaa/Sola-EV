package com.example.solaev.dto;

import com.example.solaev.model.Coordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDto {
    private String id;
    private double latitude;
    private double longitude;

    public CoordinatesDto(Coordinates coordinates) {
        this.id = coordinates.getId().toString();
        this.latitude = coordinates.getLatitude();
        this.longitude = coordinates.getLongitude();
    }
}
