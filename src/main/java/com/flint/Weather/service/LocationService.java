package com.flint.Weather.service;

import com.flint.Weather.entity.Location;
import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.entity.User;
import com.flint.Weather.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
//    private LocationResponse locationResponse;
//    @Value("${search.page.size}")

    private Optional<Location> location;
    public LocationResponse getLocation(){
        return null;
    }

    public void deleteLocationById(Integer id){
        locationRepository.deleteById(id);
    }

    public boolean checkLocationInDB(List<LocationResponse> locationResponse){

        locationResponse.stream().forEach(x->{
//            log.info(x.getName() + " " + x.getCountry());
            location = locationRepository.findByNameAndCountry(x.getName(), x.getCountry());
        });
        return location.isPresent();
    }

    public void saveLocation(Location location, User user){
        location.setUser(user);
        locationRepository.save(location);
        log.info("Save location: " + location.getName());
    }

}
