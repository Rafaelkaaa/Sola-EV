package com.example.solaev.service;

import com.example.solaev.dto.CoordinatesDto;
import com.example.solaev.model.Coordinates;
import com.example.solaev.repository.CoordinatesRepo;
import com.example.solaev.util.ModelUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CoordinatesServiceTest {
    @InjectMocks
    CoordinatesService coordinatesService;
    @Mock
    CoordinatesRepo coordinatesRepo;

    private final CoordinatesDto coordinatesDto = ModelUtils.getCoordinatesDto();
    private final Coordinates coordinates = ModelUtils.getCoordinates();

    @Test
    void createValidTest() {
        when(coordinatesRepo.save(coordinates)).thenReturn(coordinates);
        Coordinates actual = coordinatesService.create(coordinatesDto);
        assertEquals(coordinates,actual);
    }

    @Test
    void createWithInvalidLatitudeTest(){
        coordinatesDto.setLatitude(181);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                coordinatesService.create(coordinatesDto));
        String expectedMessage = "Latitude mustn't be biggest than 180";
        assertEquals(expectedMessage, exception.getMessage());
    }
    @Test
    void createWithInvalidLongitudeTest(){
        coordinatesDto.setLongitude(-91);
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                coordinatesService.create(coordinatesDto));
        String expectedMessage = "Longitude mustn't be less than -90";
        assertEquals(expectedMessage, exception.getMessage());
    }
}
