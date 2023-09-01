package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.Connect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/index")
    public String home(Model model)
    {
       // model.addAttribute("title", "Погода");
//        String NameCity = "Самара";
//        Double CurrTemp = 25.0;
        // Название города
        //DataWeather dw = new DataWeather();
        Connect dw = new Connect();
        dw.initialize();
        model.addAttribute("city", dw.getNameCity());



        model.addAttribute("temp", dw.getCurrTemp(0));
        model.addAttribute("pressure", dw.getPressure(0));
        model.addAttribute("speed", dw.getwindspeed(0));
        model.addAttribute("humidity", dw.getHumidity(0));
        model.addAttribute("feels_like", dw.getFeelsLike(0));
        model.addAttribute("image", dw.getImage(0));
        model.addAttribute("image1", dw.getImage(1));
        System.out.println("Image : " + dw.getImage(0));

        // Смена дня/ночи
        model.addAttribute("fgg", dw.isDay());

        return "index";
    }



}
//    @RequestMapping("/variable-example1")
//    public String variableExample1(Model model, HttpServletRequest request) {
//        // variable1
//        model.addAttribute("variable1", "Value of variable1!");
//        // variable2
//        request.setAttribute("variable2", "Value of variable2!");
//        return "variable-example1";
//    }