package com.example.solaev.controller;

import com.example.solaev.dto.charging_station.ChargingStationDto;
import com.example.solaev.dto.charging_station.ChargingStationRequestDto;
import com.example.solaev.service.ChargingStationService;
import com.example.solaev.util.ModelUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ChargingStationControllerTest {
    @InjectMocks
    private ChargingStationController chargingStationController;
    @Mock
    private ChargingStationService chargingStationService;
    private MockMvc mockMvc;

    private final ChargingStationRequestDto chargingStationRequestDto = ModelUtils.getChargingStationRequestDto();
    private final ChargingStationDto chargingStationDto = ModelUtils.getChargingStationDto();
    private final String link = "/api/charging_station";

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(chargingStationController)
                .build();
    }

    @Test
    void saveChargingStationTest() throws Exception {
        when(chargingStationService.create(chargingStationRequestDto)).thenReturn(chargingStationDto);
        mockMvc.perform(post(link)
                        .content(new ObjectMapper().writeValueAsString(chargingStationRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(chargingStationService).create(chargingStationRequestDto);
    }
}
