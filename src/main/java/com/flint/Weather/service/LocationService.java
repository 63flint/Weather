package com.flint.Weather.service;

import com.flint.Weather.entity.Location;
import com.flint.Weather.dto.LocationResponse;
import com.flint.Weather.entity.User;
import com.flint.Weather.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public void savedLocation(List<LocationResponse> locationResponses, Long userId){
        for (LocationResponse location: locationResponses) {
            Optional<Location> locationDB = getLocationFromDb(location, userId);

            // Проверка, что такая локация уже записана в БД
            if(locationDB.isPresent()){
                location.setId(locationDB.get().getId());
                location.setSaved(true);
            }
        }
    }

    public void saveUserInLocation(Location location, User user){
        location.setUser(user);
        locationRepository.save(location);
        log.info("Save location: " + location.getName());
    }

    public void deleteLocation(Integer id){
        locationRepository.deleteById(id);
    }

    public Location getLocationById(Integer id){
        Optional<Location> location = locationRepository.findById(id);
        if(location.isEmpty()) {
            log.error("Location not exist");
        }
        return location.get();
    }

    public List<Location> getAllUserLocations(User user){
        return locationRepository.findAllByUser(user).orElse(Collections.emptyList());
    }

    private Optional<Location> getLocationFromDb(LocationResponse locationResponse, Long userId){
        return locationRepository.findByNameAndCountryAndUserId(locationResponse.getName(), locationResponse.getCountry(), userId);
    }

}
