package com.example.solaev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "charging_connector")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingConnector {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Enumerated(EnumType.STRING)
    @NotNull
    private ChargingConnectorType type;
    @Min(value = 3, message = "Maximum power of the charging connector must exceed 3 kW")
    @Max(value = 500, message = "Maximum power of the charging connector mustn't be bigger than 500 kW")
    private int maxKw;
    @ManyToMany(mappedBy = "chargingConnectors")
    private Set<ChargingStation> chargingStation;
}
