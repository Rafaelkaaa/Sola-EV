package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.convert.AddressConvertor;
import com.example.solaev.model.Address;
import com.example.solaev.repository.AddressRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    AddressRepo addressRepo;
    GoogleApiService googleApiService;

    public Address crete(CoordinatesDto coordinatesDto) {
        double latitude = coordinatesDto.getLatitude();
        double longitude = coordinatesDto.getLongitude();
        return addressRepo.save(AddressConvertor.convertToEntity(googleApiService
                .getAddressByCoordinates(latitude, longitude)));
    }
}
