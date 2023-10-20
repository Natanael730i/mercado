package com.webhostapp.natanaellucasmuller.site.model;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
public class PersonModel {
    
    @Id
    private UUID id;
    @CPF
    private String cpf;
    @Email
    private String email;
    @OneToOne(mappedBy = "id")
    private AdressModel adressModel;
}
