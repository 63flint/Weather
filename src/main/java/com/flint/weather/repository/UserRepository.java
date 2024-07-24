package com.flint.weather.repository;

import com.flint.weather.dto.LocationResponse;
import com.flint.weather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, LocationResponse> {
    Optional<User> findByEmail(String email);
}
