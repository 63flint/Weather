package com.flint.weather.controllers;

import com.flint.weather.service.WeatherApiService;
import com.flint.weather.entity.CustomUser;
import com.flint.weather.entity.Location;
import com.flint.weather.entity.User;
import com.flint.weather.dto.LocationResponse;
import com.flint.weather.service.AuthoritiesService;
import com.flint.weather.service.LocationService;
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
    private final WeatherApiService weatherApiService;

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
