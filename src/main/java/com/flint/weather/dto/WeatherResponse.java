package com.flint.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flint.weather.dto.api.weather.Coord;
import com.flint.weather.dto.api.weather.Main;
import com.flint.weather.dto.api.weather.Weather;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coord coord;
    private ArrayList<Weather> weathers;
    private String stations;
    private Main main;
    private int visibility;
}
