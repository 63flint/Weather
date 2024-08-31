package com.flint.weather.service;

import com.flint.weather.entity.Location;
import com.flint.weather.dto.LocationResponse;
import com.flint.weather.entity.User;
import com.flint.weather.repository.LocationRepository;
import com.flint.weather.utils.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void saveLocation(LocationResponse location, User user){
        Location locationBd = new Location();
        locationBd.setId(location.getId());
        locationBd.setName(location.getName());
        locationBd.setCountry(location.getCountry());
        locationBd.setLongitude(location.getLongitude());
        locationBd.setLatitude(location.getLatitude());
        locationBd.setUser(user);

        if (getLocationFromDb(location, user.getId()).isEmpty()) {
            locationRepository.save(locationBd);
            log.info("Save location: " + location.getName());
        } else {
            log.info("Location " + location.getName() + " already exist");
        }
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

    public Page<LocationResponse> getAllUserLocations(User user, PageRequest pageRequest){
        List<Location> locations = locationRepository.findPageableLocations(user.getId(), pageRequest).orElse(Collections.emptyList());
        List<LocationResponse> ls = locations.stream().map(x->Json.parse(x, LocationResponse.class)).toList();
        return new PageImpl<>(ls, pageRequest, pageRequest.getPageSize());
    }

    private Optional<Location> getLocationFromDb(LocationResponse locationResponse, Long userId){
        return locationRepository.findByNameAndLatitudeAndLongitudeAndUserId(locationResponse.getName(), locationResponse.getLatitude(), locationResponse.getLongitude(), userId);
    }

}
