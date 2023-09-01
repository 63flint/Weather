package com.flint.Weather.service;

import com.flint.Weather.weatherPojo.Day;
import com.flint.Weather.weatherPojo.MainWeather;

public class ForecastService {
    private MainWeather mainWeather;

    public ForecastService(MainWeather mainWeather){
        this.mainWeather = mainWeather;
    }

    public Day getDayWeather(){
        return mainWeather.getList().get(0);
    }

    public String getCity(){
        return mainWeather.getCity().getName();
    }
}
