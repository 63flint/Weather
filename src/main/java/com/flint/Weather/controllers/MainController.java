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
        Day day1 = forecastService.getDayWeather(0);
        model.addAttribute("temp1", day1.getMain().getTemp());
        model.addAttribute("pressure", day1.getMain().getPressure());
        model.addAttribute("speed", day1.getWind().getSpeed());
        model.addAttribute("humidity", day1.getMain().getHumidity());
        model.addAttribute("feels_like", day1.getMain().getFeels_like());
        model.addAttribute("image1", forecastService.getIcon(0));

        //2
        Day day2 = forecastService.getDayWeather(1);
        model.addAttribute("temp2", day2.getMain().getTemp());
        model.addAttribute("time2", forecastService.getTime(day2.getDt_txt()));
        model.addAttribute("image2", forecastService.getIcon(1));

        // 3
        Day day3 = forecastService.getDayWeather(2);
        model.addAttribute("temp3", day3.getMain().getTemp());
        model.addAttribute("time3", forecastService.getTime(day3.getDt_txt()));
        model.addAttribute("image3", forecastService.getIcon(2));

        // 4
        Day day4 = forecastService.getDayWeather(3);
        model.addAttribute("temp4", day4.getMain().getTemp());
        model.addAttribute("time4", forecastService.getTime(day4.getDt_txt()));
        model.addAttribute("image4", forecastService.getIcon(3));

        // 5
        Day day5 = forecastService.getDayWeather(4);
        model.addAttribute("temp5", day5.getMain().getTemp());
        model.addAttribute("time5", forecastService.getTime(day5.getDt_txt()));
        model.addAttribute("image5", forecastService.getIcon(4));
        // 6
        Day day6 = forecastService.getDayWeather(5);
        model.addAttribute("temp6", day6.getMain().getTemp());
        model.addAttribute("time6", forecastService.getTime(day6.getDt_txt()));
        model.addAttribute("image6", forecastService.getIcon(5));

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