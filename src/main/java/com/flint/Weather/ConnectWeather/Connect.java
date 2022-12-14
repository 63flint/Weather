package com.flint.Weather.ConnectWeather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class WeatherData {
    double feels_like=0.0;
    double temp_max=0.0;
    double temp_min=0.0;
    double pressure=0.0;
    double temp=0.0;
    double humidity; //влажность
    double windspeed; // скорость ветра
    double sunrise;    // восход
    double sunset;      // закат
    String imageJson;
}


public class Connect {
    double temp;
    double feels_like;
    double temp_max;
    double temp_min;
    double pressure;
    double sunrise;
    double sunset;
    final int CNT = 40;
    final String appId = "827ab0f94bca74870eb83bc59999ed23";
    final String [] ICON = {"icon__01d", "icon__02d","icon__03d","icon__04d","icon__09d","icon__10d","icon__01n","icon__50d"};
    String [] imageJson= new String[6];

    String city = "Samara";

    // время на компе
    double now = System.currentTimeMillis();
    WeatherData[] weatherData = new WeatherData[6];

   public void initialize() {
       //api.openweathermap.org/data/2.5/weather?q=Samara&appid=827ab0f94bca74870eb83bc59999ed23&units=metric
       //api.openweathermap.org/data/2.5/forecast?q=Samara&appid=827ab0f94bca74870eb83bc59999ed23&units=metric
        String output = getUrlContent("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + appId + "&units=metric");
        System.out.println(output);

        // инициализация объектов т.к они не могут быть пустыми
       for (int i = 0; i< weatherData.length; i++) {
           weatherData[i] = new WeatherData();
       }

        if (!output.isEmpty()) { // Нет ошибки и такой город есть

            JSONObject obj = new JSONObject(output);
            JSONArray arr = (JSONArray) obj.get("list");
            //JSONArray arr2 = (JSONArray) obj.get("weather");

//            temp = obj.getJSONObject("main").getDouble("temp");
//            feels_like = obj.getJSONObject("main").getDouble("feels_like");
//            temp_max = obj.getJSONObject("main").getDouble("temp_max");
//            temp_min = obj.getJSONObject("main").getDouble("temp_min");
//            pressure =obj.getJSONObject("main").getDouble("pressure");
//            zz = (long) (dt * 1000.0);
//            Date date = new Date(zz);
//            SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            jdf.format(date);

            // время с сервера
            sunrise = obj.getJSONObject("city").getDouble("sunrise");
            sunset = obj.getJSONObject("city").getDouble("sunset");

            int count = 0;
            JSONObject obj2;
            try {
                for (int i = 0; i < CNT-6; i++) {
                    obj2 = (JSONObject) arr.get(i);

                    System.out.println((long) (obj2.getDouble("dt") - 10800));
                    if (count < 6) {
                        if (now < ((long) (obj2.getDouble("dt") * 1000))) {
                            System.out.println("START");
                            weatherData[count].feels_like = obj2.getJSONObject("main").getDouble("feels_like");
                            weatherData[count].temp_max = obj2.getJSONObject("main").getDouble("temp_max");
                            weatherData[count].temp_min = obj2.getJSONObject("main").getDouble("temp_min");
                            weatherData[count].pressure = obj2.getJSONObject("main").getDouble("pressure");
                            weatherData[count].temp = obj2.getJSONObject("main").getDouble("temp");
                            weatherData[count].humidity = obj2.getJSONObject("main").getDouble("humidity");
                            weatherData[count].windspeed = obj2.getJSONObject("wind").getDouble("speed");
                            //weatherData[count].imageJson = obj2.get("weather");
                            //JSONArray arr2 = (JSONArray) obj2.getJSONObject("weather");


                            JSONArray arr2;
                            //arr2 = (JSONArray) obj2.get("weather");
                            arr2 = (JSONArray) obj2.getJSONArray("weather");
                            JSONObject obj3 = arr2.getJSONObject(0);
//                            JSONObject obj3 = (JSONObject) arr2.get(3);
//                            weatherData[count].imageJson = obj3.getString("icon");
                            weatherData[count].imageJson = obj3.getString("icon");
                            System.out.println(obj3.get("icon"));
                            System.out.println(weatherData[count].temp);
                            System.out.println(i);
                            count++;
                        }
                    }else
                        break;
                    }
            }
            catch (Exception e)
            {
                System.out.println("err arr" + e);
            }


        }
    }


    // определяем день/ночь
    public String isDay(){
        return now > (sunrise * 1000) && now < (sunset * 1000) ? "day" : "night";
    }


    public String getImage (int index){
        String str = "";
            for (int j = 0; j < ICON.length + 1; j++) {
                System.out.println(ICON[j]);
                if (ICON[j].contains(weatherData[index].imageJson)) {
                    str = ICON[j];
                    break;
                }
            }
        return str;
    }

    public String getNameCity() {
        return city;
    }

    public Double getCurrTemp(int index) {
        return weatherData[index].temp;
    }

    public Double getFeelsLike(int index){
        return weatherData[index].feels_like;
    }

    public double getTemp_max(int index) {
        return weatherData[index].temp_max;
    }

    public double getTemp_min(int index) {
        return weatherData[index].temp_min;
    }

    public double getPressure(int index) {
        return weatherData[index].pressure;
    }

    public double getwindspeed(int index){
       return weatherData[index].windspeed;
    }

    public double getHumidity(int index) {
        return weatherData[index].humidity;
    }

    public String getIcon(int index){
       return  weatherData[index].imageJson;
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
