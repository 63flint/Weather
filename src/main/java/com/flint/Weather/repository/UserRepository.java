package com.flint.Weather.repository;

import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, LocationResponse> {

}
