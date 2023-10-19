package com.webhostapp.natanaellucasmuller.site.repository;

import com.webhostapp.natanaellucasmuller.site.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
