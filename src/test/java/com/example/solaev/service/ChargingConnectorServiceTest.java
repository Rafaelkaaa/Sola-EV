package com.example.solaev.service;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.model.ChargingConnector;
import com.example.solaev.model.ChargingConnectorType;
import com.example.solaev.repository.ChargingConnectorRepo;
import com.example.solaev.util.ModelUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargingConnectorServiceTest {
    @InjectMocks
    ChargingConnectorService chargingConnectorService;
    @Mock
    ChargingConnectorRepo chargingConnectorRepo;

    private final ChargingConnectorDto chargingConnectorDto = ModelUtils.getChargingConnectorDto();
    private final ChargingConnector chargingConnector = ModelUtils.getChargingConnector();


    @Test
    void createValidTest() {
        when(chargingConnectorRepo.save(chargingConnector)).thenReturn(chargingConnector);
        List<ChargingConnector> actual = chargingConnectorService.create(Collections.singletonList(chargingConnectorDto));
        assertEquals(Collections.singletonList(chargingConnector), actual);
    }

    @Test
    void createWithInvalidConnectorTypeTest() {
        chargingConnectorDto.setType("InvalidConnectorType");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                chargingConnectorService.create(Collections.singletonList(chargingConnectorDto)));
        String expectedMessage = "Allowable values for the connector: " + Arrays.toString(ChargingConnectorType.values());
        assertEquals(expectedMessage, exception.getMessage());
    }
}
