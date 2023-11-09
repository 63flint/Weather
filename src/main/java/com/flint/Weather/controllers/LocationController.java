package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    private WeatherApiService weatherApiService = new WeatherApiService();
    private LocationService locationService;
    @GetMapping("/controllers")
    public String loginPAge(Model model){

        model.addAttribute("locations", weatherApiService.getLocation("Samara"));
        return "controllers";
    }
}
