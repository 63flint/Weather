package com.flint.Weather.controllers;

import com.flint.Weather.dto.UserRegistration;
import com.flint.Weather.service.RegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @GetMapping("/")
    public String showHomePage(Model model) {
//        model.addAttribute("user", userDetails);
        log.info("redirect on index page");
        return "locations";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserRegistration());
        return "register";
    }

    // Регистрация нового пользователя
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserRegistration userRegisterRequestDTO, BindingResult validateResult, Model model,
                               HttpServletRequest request){

        if(validateResult.hasErrors()){
            model.addAttribute("user", userRegisterRequestDTO);
            log.info("Error in page register");
            return "/register";
        }

        log.info(userRegisterRequestDTO.getLastName());
        registerService.saveUser(userRegisterRequestDTO);
        return "redirect:/locations";
    }


}
