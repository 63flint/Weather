package com.flint.Weather.repository;

import com.flint.Weather.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByNameAndCountry(String name, String country);
    Optional<Location> findByNameAndCountryAndUserId(String name, String country, Long userId);
}
