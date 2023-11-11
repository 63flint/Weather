package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class LocationController {
    private WeatherApiService weatherApiService = new WeatherApiService();
    private LocationService locationService;
    @GetMapping("/controllers")
    public String loginPAge(Model model){

        model.addAttribute("locations", weatherApiService.getLocation("Samara"));
        return "controllers";
    }

    @GetMapping("{id}/delete")
    public String deleteLocation(@PathVariable("id") Integer locationId){

        return "redirect:/";
    }
}
