package com.example.solaev.dto;

import com.example.solaev.model.ChargingConnector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingConnectorDto {
    public ChargingConnectorDto(ChargingConnector chargingConnector) {
        this.id = chargingConnector.getId().toString();
        this.type = chargingConnector.getType().name();
        this.maxKw = chargingConnector.getMaxKw();
    }

    private String id;
    private String type;
    private int maxKw;
}
