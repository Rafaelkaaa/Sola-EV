package com.example.solaev.repository;

import com.example.solaev.model.ChargingConnector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChargingConnectorRepo extends JpaRepository<ChargingConnector, UUID> {
}
