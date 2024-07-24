package com.flint.weather.controllers;

import com.flint.weather.dto.UserRegistration;
import com.flint.weather.entity.CustomUser;
import com.flint.weather.entity.User;
import com.flint.weather.service.RegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
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

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @GetMapping("/")
    public String showHomePage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        // Если авторизация не пройдена userDetails = null
        model.addAttribute("user", userDetails);
        if (userDetails != null) {
            User user = ((CustomUser) userDetails).getUser();
            model.addAttribute("user_name", user.getName());
        }
        log.info("redirect on index page");
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        log.info("login");
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
                               HttpServletRequest request) throws ServletException {

        if(validateResult.hasErrors()){
            model.addAttribute("user", userRegisterRequestDTO);
            log.info("Error in page register");
            return "/register";
        }

        log.info(userRegisterRequestDTO.getLastName());
        registerService.saveUser(userRegisterRequestDTO);

        request.login(userRegisterRequestDTO.getEmail(), userRegisterRequestDTO.getPassword());
        return "redirect:/";
    }


}
