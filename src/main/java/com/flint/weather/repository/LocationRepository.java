package com.flint.weather.repository;

import com.flint.weather.dto.LocationResponse;
import com.flint.weather.entity.Location;
import com.flint.weather.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByNameAndCountry(String name, String country);
    Optional<Location> findByNameAndCountryAndUserId(String name, String country, Integer userId);
    Optional<Location> findByNameAndLatitudeAndLongitudeAndUserId(String name, Double latitude, Double longitude, Integer userId);
    Optional<List<Location>> findAllByUser(User user);

//    @Query(value = "SELECT l FROM Location l WHERE l.user.id = :userId")
    @Query(value = "SELECT * FROM Location l WHERE l.user_id = :userId", nativeQuery = true)
    Page<Location> findAllByUserId(Integer userId, Pageable pageable);
}
