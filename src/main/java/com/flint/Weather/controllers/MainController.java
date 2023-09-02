package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.service.ForecastService;
import com.flint.Weather.weatherPojo.Day;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    private WeatherApiService dw = new WeatherApiService();
    private ForecastService forecastService = new ForecastService(dw.getWeatherData());

    @GetMapping("/index")
    public String home(Model model)
    {

        dw.initialize();
        model.addAttribute("city", forecastService.getCity());

        // 1
        model.addAttribute("temp", dw.getCurrTemp(0));
        model.addAttribute("pressure", dw.getPressure(0));
        model.addAttribute("speed", dw.getwindspeed(0));
        model.addAttribute("humidity", dw.getHumidity(0));
        model.addAttribute("feels_like", dw.getFeelsLike(0));
        model.addAttribute("image", dw.getImage(0));
        model.addAttribute("image1", dw.getImage(1));

        // 3
        Day day3 = forecastService.getDayWeather(2);
        model.addAttribute("temp3", day3.getMain().getTemp());
        model.addAttribute("time3", forecastService.getTime(day3.getDt_txt()));
        model.addAttribute("image3", "icon__01n");

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