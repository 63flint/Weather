package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.model.LocationResponse;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private WeatherApiService weatherApiService = new WeatherApiService();
    private LocationService locationService;
    @GetMapping
    public String search(@ModelAttribute("startString") String startString, Model model){

        boolean button = true;
        LocationResponse locationResponse = weatherApiService.getLocation(startString).get(0);

        System.out.println(locationResponse.getName());
        System.out.println(locationResponse.getCountry());
        System.out.println(locationResponse.getLatitude());
        System.out.println(locationResponse.getLongitude());
        model.addAttribute("locations", weatherApiService.getLocation(startString));
        model.addAttribute("isSaved", button);
        return "search";
    }
}
