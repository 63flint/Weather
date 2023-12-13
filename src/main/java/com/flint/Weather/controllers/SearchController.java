package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.entity.CustomUser;
import com.flint.Weather.entity.Location;
import com.flint.Weather.entity.User;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final LocationService locationService;
    private WeatherApiService weatherApiService = new WeatherApiService();

    @GetMapping
    public String search(@ModelAttribute("startString") String startString, Model model, @AuthenticationPrincipal UserDetails userDetails){
//        User user = ((CustomUser) userDetails).getUser();

        model.addAttribute("locations", weatherApiService.getLocation(startString));
        model.addAttribute("newLocation", new Location());
        model.addAttribute("isSaved", locationService.checkLocationInDB(weatherApiService.getLocation(startString)));
        return "search";
    }


}
