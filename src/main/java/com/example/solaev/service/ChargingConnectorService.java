package com.example.solaev.service;

import com.example.solaev.dto.ChargingConnectorDto;
import com.example.solaev.model.ChargingConnector;
import com.example.solaev.repository.ChargingConnectorRepo;
import com.example.solaev.util.ConvertToEntityUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ChargingConnectorService {
    private ChargingConnectorRepo chargingConnectorRepo;

    public List<ChargingConnector> create(List<ChargingConnectorDto> chargingConnectorDtos) {
        return chargingConnectorDtos.stream()
                .map(chargingConnectorDto -> chargingConnectorRepo
                        .save(ConvertToEntityUtils.convert(chargingConnectorDto)))
                .toList();
    }
}
