package com.flint.Weather.repository;

import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, LocationResponse> {
//    Optional<User> findByUsername(String username);
}
