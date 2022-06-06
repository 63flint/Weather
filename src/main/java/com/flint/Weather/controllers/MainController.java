package com.flint.Weather.controllers;

import com.flint.Weather.ConnectWeather.Connect;
import com.flint.Weather.ConnectWeather.DataWeather;
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

    for(int i=0; i<6; i++){
        model.addAttribute("temp", dw.getCurrTemp(i));
        model.addAttribute("pressure", dw.getPressure(i));
        model.addAttribute("speed", dw.getwindspeed(i));
        model.addAttribute("humidity", dw.getHumidity(i));
        model.addAttribute("feels_like", dw.getFeelsLike(i));
    }

        model.addAttribute("fgg", dw.isDay());
        String bb[]=new String[6];
        bb = dw.Image();
        model.addAttribute("image", bb[0]);

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