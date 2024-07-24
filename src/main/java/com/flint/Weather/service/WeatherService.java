package com.flint.Weather.service;

import com.flint.Weather.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {
    private final WeatherApiService weatherApiService;

    private WeatherResponse weatherResponse = new WeatherResponse();

    public void search(String city){
        weatherResponse = weatherApiService.getWeatherData(city);
    }

    public double getCurrentTemp(){
        return this.weatherResponse.getMain().getTemp();
    }
}
