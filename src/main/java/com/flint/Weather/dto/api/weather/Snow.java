package com.flint.Weather.dto.api.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {
    private double h;

    @JsonProperty("3h")
    public double getH() {
        return h;
    }
    @JsonProperty("3h")
    public void setH(double h) {
        this.h = h;
    }
}
