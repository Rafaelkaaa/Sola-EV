package com.example.solaev.dto.convert;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.model.ChargingConnector;
import com.example.solaev.model.ChargingConnectorType;

import java.util.UUID;

public class ChargingConnectorConvertor {
    public static ChargingConnector convertToEntity(ChargingConnectorDto chargingConnectorDto) {
        ChargingConnector chargingConnector = ChargingConnector.builder()
                .type(ChargingConnectorType.valueOf(chargingConnectorDto.getType()))
                .maxKw(chargingConnectorDto.getMaxKw())
                .build();
        if (chargingConnectorDto.getId() != null){
            chargingConnector.setId(UUID.fromString(chargingConnectorDto.getId()));
        }
        return chargingConnector;
    }
}
