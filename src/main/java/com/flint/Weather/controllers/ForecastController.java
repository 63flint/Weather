package com.flint.Weather.controllers;

import com.flint.Weather.connectWeatherAPI.WeatherApiService;
import com.flint.Weather.entity.Location;
import com.flint.Weather.service.ForecastService;
import com.flint.Weather.model.api.entity.Day;
import com.flint.Weather.service.LocationService;
import com.flint.Weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("forecast")
@RequiredArgsConstructor
public class ForecastController {
    private final LocationService locationService;
    private WeatherApiService weatherApiService = new WeatherApiService();
    private ForecastService forecastService;
    private WeatherService weatherService;

    @GetMapping("/{location_id}")
//    @GetMapping("/forecast")
    public String loadForecastWeather(@PathVariable int location_id, Model model)
    {
        Location location = locationService.getLocationById(location_id);
        log.info(location.getName());

        forecastService = new ForecastService(weatherApiService.getForecastData(location.getName()));
        weatherService = new WeatherService(weatherApiService.getWeatherData(location.getName()));

        // main
        model.addAttribute("city", forecastService.getCity());

        // 1
        Day today = forecastService.getDayWeather(0);
//        model.addAttribute("temp1", today.getMain().getTemp());
        model.addAttribute("temp1", weatherService.getCurrentTemp());
        model.addAttribute("pressure", today.getMain().getPressure());
        model.addAttribute("speed", today.getWind().getSpeed());
        model.addAttribute("humidity", today.getMain().getHumidity());
        model.addAttribute("feels_like", today.getMain().getFeels_like());
        model.addAttribute("image1", forecastService.getIcon(0));
        model.addAttribute("description", today.getWeather().get(0).getDescription());
        model.addAttribute("serverTime",  forecastService.getTime(today.getDt_txt()));

        //2
        Day offset_0h = forecastService.getDayWeather(0);
        model.addAttribute("temp2", offset_0h.getMain().getTemp());
        model.addAttribute("time2", forecastService.getTime(offset_0h.getDt_txt()));
        model.addAttribute("image2", forecastService.getIcon(0));

        // 3
        Day offset_3h = forecastService.getDayWeather(1);
        model.addAttribute("temp3", offset_3h.getMain().getTemp());
        model.addAttribute("time3", forecastService.getTime(offset_3h.getDt_txt()));
        model.addAttribute("image3", forecastService.getIcon(1));

        // 4
        Day offset_6h = forecastService.getDayWeather(2);
        model.addAttribute("temp4", offset_6h.getMain().getTemp());
        model.addAttribute("time4", forecastService.getTime(offset_6h.getDt_txt()));
        model.addAttribute("image4", forecastService.getIcon(2));

        // 5
        Day offset_9h = forecastService.getDayWeather(3);
        model.addAttribute("temp5", offset_9h.getMain().getTemp());
        model.addAttribute("time5", forecastService.getTime(offset_9h.getDt_txt()));
        model.addAttribute("image5", forecastService.getIcon(3));
        // 6
        Day offset_12h = forecastService.getDayWeather(4);
        model.addAttribute("temp6", offset_12h.getMain().getTemp());
        model.addAttribute("time6", forecastService.getTime(offset_12h.getDt_txt()));
        model.addAttribute("image6", forecastService.getIcon(4));

        // Смена дня/ночи
        model.addAttribute("fgg", forecastService.isDay());

        return "forecast";
    }
}
