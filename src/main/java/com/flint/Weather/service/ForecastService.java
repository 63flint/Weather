package com.flint.Weather.service;

import com.flint.Weather.weatherPojo.Day;
import com.flint.Weather.weatherPojo.MainWeather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ForecastService {
    private MainWeather mainWeather;

    public ForecastService(MainWeather mainWeather){
        this.mainWeather = mainWeather;
    }

    public Day getDayWeather(int index){
        double now = System.currentTimeMillis();

        return mainWeather.getList().get(index);
    }

    public String getCity(){
        return mainWeather.getCity().getName();
    }

    public String getTime(String time) {
        LocalDateTime localDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ZoneId zoneId = ZoneId.of("Europe/Samara");
        ZonedDateTime zdt = localDateTime.atZone(ZoneOffset.UTC).withZoneSameInstant(zoneId);
        System.out.println(zdt);
        return String.format("%02d", zdt.getHour());
    }

    public String getIcon(int index){
        return "icon__" + mainWeather.getList().get(index).getWeather().get(0).getIcon();
    }

    public String isDay(){
        long time = mainWeather.getList().get(0).getDt();
        return time > mainWeather.getCity().getSunrise() && time < mainWeather.getCity().getSunset() ? "day" : "night";
    }


}
