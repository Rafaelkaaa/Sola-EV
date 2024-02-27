package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.convert.CoordinatesConvertor;
import com.example.solaev.model.Coordinates;
import com.example.solaev.repository.CoordinatesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoordinatesService {
    CoordinatesRepo coordinatesRepo;

    public Coordinates crete(CoordinatesDto coordinatesDto) {
        return coordinatesRepo.save(CoordinatesConvertor.convertToEntity(coordinatesDto));
    }
}
