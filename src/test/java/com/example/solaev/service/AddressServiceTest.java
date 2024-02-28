package com.example.solaev.service;

import com.example.solaev.dto.AddressDto;
import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.Address;
import com.example.solaev.repository.AddressRepo;
import com.example.solaev.util.ModelUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @InjectMocks
    private AddressService addressService;
    @Mock
    private AddressRepo addressRepo;
    @Mock
    private GoogleApiService googleApiService;

    private final double latitude = ModelUtils.getLatitude();
    private final double longitude = ModelUtils.getLongitude();
    private final AddressDto addressDto = ModelUtils.getAddressDto();
    private final CoordinatesDto coordinatesDto = ModelUtils.getCoordinatesDto();
    private final Address address = ModelUtils.getAddress();

    @Test
    void createValidTest() {
        when(googleApiService.getAddressByCoordinates(latitude, longitude)).thenReturn(addressDto);
        when(addressRepo.save(address)).thenReturn(address);
        Address actual = addressService.create(coordinatesDto);
        assertEquals(address, actual);
    }

    @Test
    void creteWithInvalidCoordinatesTest() {
        coordinatesDto.setLatitude(181);
        Address actual = addressService.create(coordinatesDto);
        assertNull(actual);
    }
}
