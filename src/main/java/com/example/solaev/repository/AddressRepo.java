package com.example.solaev.repository;

import com.example.solaev.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {}

