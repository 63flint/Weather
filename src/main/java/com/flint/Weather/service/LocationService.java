package com.flint.Weather.service;

import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.repository.LocationRepository;

public class LocationService {

    private LocationRepository locationRepository;
    private LocationResponse locationResponse;

    public LocationService(LocationResponse locationResponse) {
        this.locationResponse = locationResponse;
    }

    public LocationResponse getLocation(){
        return null;
    }

    public void deleteLocationById(Integer id){
        locationRepository.deleteById(id);
    }
}
