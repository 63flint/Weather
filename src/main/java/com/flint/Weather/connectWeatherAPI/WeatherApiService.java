package com.flint.Weather.connectWeatherAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.flint.Weather.dto.ForecastResponse;
import com.flint.Weather.dto.LocationResponse;
import com.flint.Weather.dto.WeatherResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class WeatherApiService {
    private static final String APP_ID = "827ab0f94bca74870eb83bc59999ed23";
    private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String GEOCODING_URL = "http://api.openweathermap.org/geo/1.0/direct?q=";
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final int TIME_OUT = 120000;
    public WeatherApiService(){
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


    // Получить прогноз погоды на 3 дня каждые 3 часа
    public ForecastResponse getForecastData(String city) {
        try {
            String output = getUrlContent(buildForecastUrl(city));
            log.info("Request forecast: get city: " + city + " response: " + output);
            ForecastResponse forecastResponse = objectMapper.readValue(output, ForecastResponse.class);
            return forecastResponse;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parse JSON Object", e);
        }
    }

    // текущая погода
    public WeatherResponse getWeatherData(String city) {
        try {
            String output = getUrlContent(buildWeatherUrl(city));
            log.info("Request weather: get city: " + city + " response: " + output);
            WeatherResponse weatherResponse = objectMapper.readValue(output, WeatherResponse.class);
            return weatherResponse;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LocationResponse> getLocation(String city) {
        try {
            String output = getUrlContent(buildLocationUrl(city));
            log.info("get city: " + city + " response: " + output);
            List<LocationResponse> weatherResponse = objectMapper.readValue(output, new TypeReference<List<LocationResponse>>() {
            });
            return weatherResponse;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildForecastUrl(String city) {
        return FORECAST_URL + city.replace(" ", "%20") + "&appid=" + APP_ID + "&units=metric";
    }

    private String buildWeatherUrl(String city) {
        return WEATHER_URL + city.replace(" ", "%20") + "&appid=" + APP_ID + "&units=metric";
    }

    private String buildLocationUrl(String city) {
        return GEOCODING_URL + city.replace(" ", "%20") + "&limit=5&appid=" + APP_ID;
    }


    // Возвращает строку в формате JSON с данными о погоде.
    private String getUrlContent(String urlAddress) {
        StringBuffer content = new StringBuffer();
        BufferedReader bufferedReader=null;
        try {
            URL url = new URL(urlAddress);
            // Подключение по ссылке
            URLConnection urlCon = url.openConnection();
//            urlCon.setReadTimeout(TIME_OUT);
            urlCon.setConnectTimeout(TIME_OUT);
            bufferedReader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            return content.toString();

        }catch(IOException e){
            throw new RuntimeException("Failed to read connect from URL: " + e.getMessage());
        } finally {
            if (bufferedReader != null ) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException("Error closing BufferedReader: " + e.getMessage());
                }
            }
        }
    }

}
