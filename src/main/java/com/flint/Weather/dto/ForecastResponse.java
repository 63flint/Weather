package com.flint.Weather.dto;

import com.flint.Weather.dto.api.weather.City;
import com.flint.Weather.dto.api.weather.Day;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastResponse {
    private String cod = "";
    private int message;
    private String cnt = "";
    private ArrayList<Day> list;
    private City city;
}
