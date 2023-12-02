package com.flint.Weather.controllers;

import com.flint.Weather.dto.UserRegistration;
import com.flint.Weather.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserRegistration());
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserRegistration userRegisterRequestDTO, BindingResult validateResult, Model model,
                               HttpServletRequest request){
        System.out.println(userRegisterRequestDTO.getLastName());
        registerService.saveUser(userRegisterRequestDTO);
        return "redirect:/";
    }


}
