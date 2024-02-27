package com.example.solaev.dto.convert;

import com.example.solaev.dto.AddressDto;
import com.example.solaev.model.Address;

import java.util.UUID;

public class AddressConvertor {
    public static Address convertToEntity(AddressDto addressDto){
        Address address = Address.builder()
                .houseNumber(addressDto.getHouseNumber())
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .region(addressDto.getRegion())
                .country(addressDto.getCountry())
                .build();
        if (addressDto.getId() != null){
            address.setId(UUID.fromString(addressDto.getId()));
        }
        return address;
    }
}
