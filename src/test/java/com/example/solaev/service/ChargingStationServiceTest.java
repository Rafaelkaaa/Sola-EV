package com.example.solaev.service;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.dto.charging_station.ChargingStationRequestDto;
import com.example.solaev.model.Address;
import com.example.solaev.model.ChargingConnector;
import com.example.solaev.model.ChargingStation;
import com.example.solaev.model.Coordinates;
import com.example.solaev.repository.ChargingStationRepo;
import com.example.solaev.util.ModelUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargingStationServiceTest {
    @InjectMocks
    ChargingStationService chargingStationService;
    @Mock
    private ChargingStationRepo chargingStationRepo;
    @Mock
    private ChargingConnectorService chargingConnectorService;
    @Mock
    private CoordinatesService coordinatesService;
    @Mock
    private AddressService addressService;

    private final ChargingConnectorDto chargingConnectorDto
            = ModelUtils.getChargingConnectorDto();
    private final List<ChargingConnectorDto> chargingConnectorDtoList
            = Collections.singletonList(chargingConnectorDto);
    private final ChargingConnector chargingConnector
            = ModelUtils.getChargingConnector();
    private final List<ChargingConnector> chargingConnectorList
            = Collections.singletonList(chargingConnector);
    private final CoordinatesDto coordinatesDto = ModelUtils.getCoordinatesDto();
    private final Coordinates coordinates = ModelUtils.getCoordinates();
    private final Address address = ModelUtils.getAddress();
    private final ChargingStation chargingStation = ModelUtils.getChargingStation();
    private final ChargingStationDto chargingStationDto = ModelUtils.getChargingStationDto();
    private final ChargingStationRequestDto chargingStationRequestDto = ModelUtils.getChargingStationRequestDto();

    @Test
    void createValidTest() {
        when(chargingConnectorService.create(chargingConnectorDtoList)).thenReturn(chargingConnectorList);
        when(coordinatesService.create(coordinatesDto)).thenReturn(coordinates);
        when(addressService.create(coordinatesDto)).thenReturn(address);

        ChargingStation chargingStationWithoutId = ModelUtils.getChargingStation();
        chargingStationWithoutId.setId(null);
        when(chargingStationRepo.save(chargingStationWithoutId)).thenReturn(chargingStation);

        ChargingStationDto actual = chargingStationService.create(chargingStationRequestDto);
        assertEquals(chargingStationDto, actual);
    }
    @Test
    void creatPublicWithNullTitle(){
        chargingStationRequestDto.setTitle(null);
        when(addressService.create(coordinatesDto)).thenReturn(address);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                chargingStationService.create(chargingStationRequestDto));
        String expectedMessage = "For public station, there must be no empty title";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void creatPublicWithNullDescription(){
        chargingStationRequestDto.setDescription(null);
        when(addressService.create(coordinatesDto)).thenReturn(address);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                chargingStationService.create(chargingStationRequestDto));
        String expectedMessage = "For public station, there must be no empty description";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void creatPublicWithNullAddress(){
        when(addressService.create(coordinatesDto)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                chargingStationService.create(chargingStationRequestDto));
        String expectedMessage = "For public station, there must be no null address, change coordinates";
        assertEquals(expectedMessage, exception.getMessage());
    }
}

