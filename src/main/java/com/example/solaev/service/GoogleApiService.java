package com.example.solaev.service;

import com.example.solaev.dto.AddressDto;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleApiService {
    private final GeoApiContext context;

    public GoogleApiService(@Value("${google.api.key}") String apiKey) {
        this.context = new GeoApiContext.Builder().apiKey(apiKey).build();
    }
    public AddressDto getAddressByCoordinates(double latitude, double longitude) {
        GeocodingResult[] results;
        try {
            results = GeocodingApi.reverseGeocode(context, new LatLng(latitude, longitude)).await();
        } catch (Exception e) {
            return null;
        }
        if (results == null || results.length == 0) {
            return null;
        }
        AddressDto addressDto = new AddressDto();
        AddressComponent[] addressComponents = results[0].addressComponents;
        for (AddressComponent component : addressComponents) {
            switch (component.types[0]) {
                case STREET_NUMBER -> addressDto.setHouseNumber(component.longName);
                case ROUTE -> addressDto.setStreet(component.longName);
                case LOCALITY -> addressDto.setCity(component.longName);
                case ADMINISTRATIVE_AREA_LEVEL_1 -> addressDto.setRegion(component.longName);
                case COUNTRY -> addressDto.setCountry(component.longName);
                case POSTAL_CODE -> addressDto.setPostCode(component.longName);
                default -> {
                }
            }
        }
        return addressDto;
    }
}
