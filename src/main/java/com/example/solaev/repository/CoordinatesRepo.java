package com.example.solaev.repository;

import com.example.solaev.model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoordinatesRepo extends JpaRepository<Coordinates, UUID> {
}
