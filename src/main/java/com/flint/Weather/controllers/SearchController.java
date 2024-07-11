package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.entity.CustomUser;
import com.flint.Weather.entity.Location;
import com.flint.Weather.entity.User;
import com.flint.Weather.dto.LocationResponse;
import com.flint.Weather.service.AuthoritiesService;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final LocationService locationService;
    private final AuthoritiesService authoritiesService;
    private WeatherApiService weatherApiService = new WeatherApiService();

    @GetMapping
    public String search(@ModelAttribute("startString") String startString, Model model, @AuthenticationPrincipal UserDetails userDetails){
        User user = ((CustomUser) userDetails).getUser();
        List<LocationResponse> locationResponses = weatherApiService.getLocation(startString);
        locationService.savedLocation(locationResponses, user.getId());
        model.addAttribute("locations", locationResponses);
        model.addAttribute("newLocation", new Location());
        model.addAttribute("user_name", user.getName());
        return "search";
    }


}
