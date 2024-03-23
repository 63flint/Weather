package com.flint.Weather.service;

import com.flint.Weather.model.WeatherResponse;
import org.springframework.stereotype.Service;

public class WeatherService {

    private WeatherResponse weatherResponse;

    public WeatherService(WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public double getCurrentTemp(){
        return this.weatherResponse.getMain().getTemp();
    }
}
