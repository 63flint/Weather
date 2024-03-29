package com.flint.Weather.controllers;

import com.flint.Weather.entity.CustomUser;
import com.flint.Weather.entity.Location;
import com.flint.Weather.entity.User;
import com.flint.Weather.repository.UserRepository;
import com.flint.Weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    private final UserRepository userRepository;


    @GetMapping("/{id}/delete")
    public String deleteLocation(@PathVariable("id") Integer locationId, @ModelAttribute("startString") String startString){
        locationService.deleteLocation(locationId);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("newLocation") Location location, @AuthenticationPrincipal UserDetails userDetails, @RequestParam("startString") String startString) {

        User user = ((CustomUser) userDetails).getUser();
        log.info(user.getName());
        locationService.saveUserInLocation(location, user);

        return "redirect:/search?startString=" + startString;
    }

    @GetMapping("/saved")
    public String viewSavedLocations(@AuthenticationPrincipal UserDetails userDetails, Model model){
        User user = ((CustomUser) userDetails).getUser();
        List<Location> locations = locationService.getAllUserLocations(user);
        model.addAttribute("locations", locations);
        return "locations";
    }
}
