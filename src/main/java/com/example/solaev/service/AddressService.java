package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.Address;
import com.example.solaev.repository.AddressRepo;
import com.example.solaev.util.ConvertToEntityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepo addressRepo;
    private GoogleApiService googleApiService;

    public Address create(CoordinatesDto coordinatesDto) {
        double latitude = coordinatesDto.getLatitude();
        double longitude = coordinatesDto.getLongitude();
        return addressRepo.save(ConvertToEntityUtils.convert(googleApiService
                .getAddressByCoordinates(latitude, longitude)));
    }
}
