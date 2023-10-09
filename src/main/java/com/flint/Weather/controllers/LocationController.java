package com.flint.Weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    @GetMapping("/controllers")
    public String loginPAge(Model model){


        return "controllers";
    }
}
