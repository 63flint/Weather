package com.flint.Weather.model.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
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
