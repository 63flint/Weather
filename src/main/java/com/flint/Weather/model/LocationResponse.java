package com.flint.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse {
    private String name;
    private Double latitude;
    private Double longitude;
    private String country;
}
