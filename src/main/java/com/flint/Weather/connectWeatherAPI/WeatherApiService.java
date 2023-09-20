package com.flint.Weather.connectWeatherAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.flint.Weather.weatherPojo.MainWeather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class WeatherApiService {
    private static final String APP_ID = "827ab0f94bca74870eb83bc59999ed23";
    private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String CITY = "Samara";
    private ObjectMapper objectMapper = new ObjectMapper();



    public MainWeather getForecastData() {
        try {
            String output = getUrlContent(buildForecastUrl());
            System.out.println(output);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            MainWeather mainWeather = objectMapper.readValue(output, MainWeather.class);
            return mainWeather;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parse JSON Object", e);
        }
    }

    public void getWeatherData(){
        
    }

    private String buildForecastUrl(){
       return FORECAST_URL + CITY + "&appid=" + APP_ID + "&units=metric";
    }

    private String buildWeatherUrl(){
        return WEATHER_URL + CITY + "&appid=" + APP_ID + "&units=metric";
    }


    // Возвращает строку в формате JSON с данными о погоде.
    private static String getUrlContent(String urlAdress){
        StringBuffer content = new StringBuffer();
        try{
            URL url =new URL(urlAdress);
            // Подключение по ссылке
            URLConnection urlCon = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();


        }catch(Exception e){
            System.out.println("Город не найден");
        }
        return content.toString();
    }



}
