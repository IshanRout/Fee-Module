package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.TransportPickupLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransportPickupLocationRepository extends JpaRepository<TransportPickupLocation,Integer> {
}