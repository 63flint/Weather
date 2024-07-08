package com.flint.Weather.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flint.Weather.entity.Location;
import com.flint.Weather.entity.User;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByNameAndCountry(String name, String country);
    Optional<Location> findByNameAndCountryAndUserId(String name, String country, Long userId);
    Optional<Location> findByNameAndLatitudeAndLongitudeAndUserId(String name, Double latitude, Double longitude, Long userId);
    Optional<List<Location>> findAllByUser(User user);
}
