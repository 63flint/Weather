package com.flint.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.flint.Weather.model.api.entity.Coord;
import com.flint.Weather.model.api.entity.Main;
import com.flint.Weather.model.api.entity.Weather;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    private Coord coord;
    private ArrayList<Weather> weathers;
    private String stations;
    private Main main;
    private int visibility;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public ArrayList<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(ArrayList<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getStations() {
        return stations;
    }

    public void setStations(String stations) {
        this.stations = stations;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
}
