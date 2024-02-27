package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.charging_station.ChargingStationCreateDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.dto.convert.ChargingStationConvertor;
import com.example.solaev.model.ChargingStation;
import com.example.solaev.repository.ChargingStationRepo;
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

    public ChargingStationDto crete(ChargingStationCreateDto chargingStationDto) {
        CoordinatesDto coordinatesDto = chargingStationDto.getCoordinates();
        if (chargingStationDto.isPublic()){
           if(coordinatesDto.getLatitude() == 0 && coordinatesDto.getLongitude() == 0) {
                throw new IllegalArgumentException("For public station, there must be no empty coordinates");
            }
           else if (chargingStationDto.getTitle() == null){
               throw new IllegalArgumentException("For public station, there must be no empty title");
           }
           else if (chargingStationDto.getDescription() == null){
               throw new IllegalArgumentException("For public station, there must be no empty description");
           }
        }

        ChargingStation chargingStation = ChargingStationConvertor.convertToEntity(chargingStationDto);
        chargingStation.setChargingConnectors(chargingConnectorService.crete(chargingStationDto
                .getChargingConnectors()));

        chargingStation.setCoordinates(coordinatesService.crete(coordinatesDto));
        chargingStation.setAddress(addressService.crete(coordinatesDto));
        return new ChargingStationDto(chargingStationRepo.save(chargingStation));
    }
}
