package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.Coordinates;
import com.example.solaev.repository.CoordinatesRepo;
import com.example.solaev.util.ConvertToEntityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoordinatesService {
    private CoordinatesRepo coordinatesRepo;

    public Coordinates create(CoordinatesDto coordinatesDto) {
        if (coordinatesDto.getLongitude() > 90)
            throw new IllegalArgumentException("Longitude mustn't be biggest than 90");
        if (coordinatesDto.getLongitude() < -90)
            throw new IllegalArgumentException("Longitude mustn't be less than -90");
        if (coordinatesDto.getLatitude() > 180)
            throw new IllegalArgumentException("Latitude mustn't be biggest than 180");
        if (coordinatesDto.getLatitude() < -180)
            throw new IllegalArgumentException("Latitude mustn't be less than -180");
        return coordinatesRepo.save(ConvertToEntityUtils.convert(coordinatesDto));
    }
}
