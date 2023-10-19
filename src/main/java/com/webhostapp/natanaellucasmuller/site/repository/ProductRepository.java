package com.webhostapp.natanaellucasmuller.site.repository;

import com.webhostapp.natanaellucasmuller.site.model.ProductModel;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

    public List<ProductModel> findAll();

}
