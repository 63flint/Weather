package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.model.users.User;
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

        boolean button = false;
        User user = new User();
        user.setId(100);


        model.addAttribute("locations", weatherApiService.getLocation(startString));
        model.addAttribute("isSaved", locationService.checkLocationInDB(weatherApiService.getLocation(startString)));
        return "search";
    }
}
