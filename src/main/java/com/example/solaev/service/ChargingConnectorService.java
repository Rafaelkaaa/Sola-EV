package com.example.solaev.service;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.dto.convert.ChargingConnectorConvertor;
import com.example.solaev.model.ChargingConnector;
import com.example.solaev.repository.ChargingConnectorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChargingConnectorService {
    ChargingConnectorRepo chargingConnectorRepo;

    public List<ChargingConnector> crete(List<ChargingConnectorDto> chargingConnectorDtos) {
        return chargingConnectorDtos.stream()
                .map(chargingConnectorDto -> chargingConnectorRepo
                        .save(ChargingConnectorConvertor.convertToEntity(chargingConnectorDto)))
                .toList();
    }
}
