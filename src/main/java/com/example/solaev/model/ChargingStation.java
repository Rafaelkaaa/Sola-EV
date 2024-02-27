package com.example.solaev.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "charging_station")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChargingStation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String title;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coordinates_id", referencedColumnName = "id")
    private Coordinates coordinates;
    @Column(name = "public")
    private boolean isPublic;
    @Nonnull
    @Min(value = 1, message = "Charging station mustn't be created without a connector")
    @Max(value = 8,message = "Charging station can have max 8 connectors")
    @ManyToMany
    @JoinTable(
            name = "charging_station_connector",
            joinColumns = @JoinColumn(name = "station_id"),
            inverseJoinColumns = @JoinColumn(name = "connector_id"))
    private List<ChargingConnector> chargingConnectors;
}
