package com.flint.Weather.ConnectWeather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

class weatherData {
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


    final int CNT = 40;
    final String appId = "827ab0f94bca74870eb83bc59999ed23";

    final String [] ICON = {"icon__01d", "icon__02d","icon__03d","icon__04d","icon__09d","icon__10d"};
    String [] imageJson= new String[6];

    String city = "Samara";

    // время на компе
    double now = System.currentTimeMillis();
    weatherData [] ss = new weatherData[6];

   public void initialize() {
       //http://api.openweathermap.org/data/2.5/weather?q=Samara&appid=827ab0f94bca74870eb83bc59999ed23&units=metric
        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + appId + "&units=metric");
        System.out.println(output);


       for (int i = 0; i< ss.length; i++) {
           ss[i] = new weatherData();
       }

        if (!output.isEmpty()) { // Нет ошибки и такой город есть
            JSONObject obj = new JSONObject(output);
            JSONArray arr = (JSONArray) obj.get("list");


//            temp = obj.getJSONObject("main").getDouble("temp");
//            feels_like = obj.getJSONObject("main").getDouble("feels_like");
//            temp_max = obj.getJSONObject("main").getDouble("temp_max");
//            temp_min = obj.getJSONObject("main").getDouble("temp_min");
//            pressure =obj.getJSONObject("main").getDouble("pressure");







//            zz = (long) (dt * 1000.0);
//            Date date = new Date(zz);
//            SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            jdf.format(date);
            JSONObject obj2;
            try {
                for (int i = 0; i < CNT-6; i++) {
                    obj2 = (JSONObject) arr.get(i);

                    if (now < obj2.getDouble("dt")) {
                            int jj;
                            ss[i].feels_like = obj2.getJSONObject("main").getDouble("feels_like");
                            ss[i].temp_max = obj2.getJSONObject("main").getDouble("temp_max");
                            ss[i].temp_min = obj2.getJSONObject("main").getDouble("temp_min");
                            ss[i].pressure = obj2.getJSONObject("main").getDouble("pressure");
                            ss[i].temp = obj2.getJSONObject("main").getDouble("temp");
                            ss[i].humidity = obj.getJSONObject("main").getDouble("humidity");


                            ss[i].windspeed = obj.getJSONObject("wind").getDouble("speed");


                            // время с сервера
                            ss[i].sunrise = obj.getJSONObject("sys").getDouble("sunrise");
                            ss[i].sunset = obj.getJSONObject("sys").getDouble("sunset");

                            ss[i].imageJson = obj.getJSONObject("weather").getString("icon");
                        }
                        break;
                    }
            }
            catch (Exception e)
            {
                System.out.println("err arr" + e);
            }


        }
    }

     public String [] Image() {
         final String aa[] = {"01d", "02d", "03d", "04d", "09d", "10d"};
         String bufImage[] = new String[6];
         for (int i = 0; i < 6; i++) {
             for (int j = 0; j < 6; j++) {
                 if (imageJson[i] == aa[j]) {
                     bufImage[i] = ICON[j];
                     break;
                 }

             }
         }
         System.out.println(bufImage);
         return bufImage;
     }

    // определяем день/ночь
    public String isDay(){
        return now > (ss[0].sunrise*1000) && now < (ss[0].sunset*1000) ? "day" : "night";
    }




    public String getNameCity() {
        return city;
    }

    public Double getCurrTemp(int index) {
        return ss[index].temp;
    }

    public Double getFeelsLike(int index){
        return ss[index].feels_like;
    }

    public double getTemp_max(int index) {
        return ss[index].temp_max;
    }

    public double getTemp_min(int index) {
        return ss[index].temp_min;
    }

    public double getPressure(int index) {
        return ss[index].pressure;
    }

    public double getwindspeed(int index){
       return ss[index].windspeed;
    }

    public double getHumidity(int index) {
        return ss[index].humidity;
    }

    public String getIcon(int index){
       return  ss[index].imageJson;
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
