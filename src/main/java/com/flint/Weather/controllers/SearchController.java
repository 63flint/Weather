package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.entity.Location;
import com.flint.Weather.entity.User;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final LocationService locationService;
    private WeatherApiService weatherApiService = new WeatherApiService();
    User user = new User();

    @GetMapping
    public String search(@ModelAttribute("startString") String startString, Model model){


        model.addAttribute("locations", weatherApiService.getLocation(startString));
        model.addAttribute("isSaved", locationService.checkLocationInDB(weatherApiService.getLocation(startString)));
        return "search";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("newLocation") Location location, @RequestParam("startString") String startString) {

//        User user = ((CustomUserPrincipal) userDetails).getUser();
        locationService.saveLocation(location, user);

        return "redirect:/search?startString=" + startString;
    }
}
