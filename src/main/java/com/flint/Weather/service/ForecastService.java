package com.flint.Weather.service;

import com.flint.Weather.dto.api.weather.Day;
import com.flint.Weather.dto.ForecastResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;


@Service
@RequiredArgsConstructor
@Slf4j
public class ForecastService {
    private final ForecastResponse forecastResponse;

//    public ForecastService(ForecastResponse forecastResponse){
//        this.forecastResponse = forecastResponse;
//    }

    public Day getDayWeather(int index){
        double now = System.currentTimeMillis();

        return forecastResponse.getList().get(index);
    }

    public String getCity(){
        return forecastResponse.getCity().getName();
    }

    public String getTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ZoneId zoneId = ZoneId.of("Europe/Samara");
        ZonedDateTime zdt = localDateTime.atZone(ZoneOffset.UTC).withZoneSameInstant(zoneId);
        log.info("Current time: " + zdt);
        return String.format("%02d", zdt.getHour());
    }

    public String getIcon(int index){
        return "icon__" + forecastResponse.getList().get(index).getWeather().get(0).getIcon();
    }

    public String isDay(){
        long time = forecastResponse.getList().get(0).getDt() - 10800;
        return time > forecastResponse.getCity().getSunrise() && time < forecastResponse.getCity().getSunset() ? "day" : "night";
    }


}
