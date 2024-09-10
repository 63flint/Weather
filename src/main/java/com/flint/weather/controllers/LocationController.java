package com.flint.weather.controllers;

import com.flint.weather.dto.LocationResponse;
import com.flint.weather.entity.CustomUser;
import com.flint.weather.entity.Location;
import com.flint.weather.entity.User;
import com.flint.weather.repository.UserRepository;
import com.flint.weather.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return "redirect:/location/saved";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("newLocation") LocationResponse location, @AuthenticationPrincipal UserDetails userDetails, @RequestParam("startString") String startString) {
        User user = ((CustomUser) userDetails).getUser();
        locationService.saveLocation(location, user);
        return "redirect:/search?startString=" + startString;
    }

    @GetMapping("/saved")
    public String viewSavedLocations(@AuthenticationPrincipal UserDetails userDetails, Model model,
                                     @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber){
        User user = ((CustomUser) userDetails).getUser();
        List<Location> locations = locationService.getAllUserLocations(user);


        final Integer MAX_PAGINATION_ELEMENTS = 6;
        Page<LocationResponse> locationsWithPaginations = locationService.getAllUserLocations(user, PageRequest.of(pageNumber,MAX_PAGINATION_ELEMENTS));

        List<LocationResponse> ls = locationsWithPaginations.getContent();

        model.addAttribute("total_pages", locationsWithPaginations.getTotalPages());
        model.addAttribute("currentPage", pageNumber);

        model.addAttribute("locations", ls);
        model.addAttribute("user_name", user.getName());
        return "locations";
    }
}
