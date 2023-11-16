package com.flint.Weather.controllers;

import com.flint.Weather.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;


}
