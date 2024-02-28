package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.dto.charging_station.ChargingStationRequestDto;
import com.example.solaev.model.Address;
import com.example.solaev.model.ChargingStation;
import com.example.solaev.repository.ChargingStationRepo;
import com.example.solaev.util.ConvertToEntityUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class ChargingStationService {
    private ChargingStationRepo chargingStationRepo;
    private ChargingConnectorService chargingConnectorService;
    private CoordinatesService coordinatesService;
    private AddressService addressService;

    public ChargingStationDto create(ChargingStationRequestDto chargingStationDto) {
        CoordinatesDto coordinatesDto = chargingStationDto.getCoordinates();
        Address address = addressService.create(coordinatesDto);
        if (chargingStationDto.isPublic()) {
            if (chargingStationDto.getTitle() == null || chargingStationDto.getTitle().isBlank()) {
                throw new IllegalArgumentException("For public station, there must be no empty title");
            } else if (chargingStationDto.getDescription() == null || chargingStationDto.getDescription().isBlank()) {
                throw new IllegalArgumentException("For public station, there must be no empty description");
            } else if (address == null) {
                throw new IllegalArgumentException("For public station, there must be no null address, change coordinates");
            }
        }

        ChargingStation chargingStation = ConvertToEntityUtils.convert(chargingStationDto);
        chargingStation.setChargingConnectors(chargingConnectorService.create(chargingStationDto
                .getChargingConnectors()));
        chargingStation.setCoordinates(coordinatesService.create(coordinatesDto));
        chargingStation.setAddress(address);
        return new ChargingStationDto(chargingStationRepo.save(chargingStation));
    }
}
