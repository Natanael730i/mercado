package com.webhostapp.natanaellucasmuller.site.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webhostapp.natanaellucasmuller.site.model.BuyModel;

public interface BuyRepository extends JpaRepository<BuyModel, UUID> {
    
}
