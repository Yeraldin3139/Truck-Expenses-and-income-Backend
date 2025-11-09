package com.truckapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truckapp.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
