package com.webhostapp.natanaellucasmuller.site.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdressModel {

    @Id
    private UUID id;
    private String roadName;
    private String neighborhood;
    private Integer number;
    private String CEP;
}
