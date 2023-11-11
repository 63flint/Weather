package com.flint.Weather.repository;

import com.flint.Weather.model.LocationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationResponse, Integer> {
    Optional<LocationResponse> findById(Integer id);
}
