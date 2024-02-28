package com.example.solaev.dto;

import com.example.solaev.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String id;
    private String street;
    private String houseNumber;
    private String city;
    private String region;
    private String country;
    private String postCode;

    public AddressDto(Address address) {
        this.id = address.getId().toString();
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.city = address.getCity();
        this.region = address.getRegion();
        this.country = address.getCountry();
        this.postCode = address.getPostCode();
    }
}
