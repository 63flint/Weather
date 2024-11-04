# Weather
![Main_page](/img/main_page.png)

## Overview
Application for displaying weather.


## Spring Security

## API
### OpenWeatherMap
Для приложения используется бесплатное API от [https://openweathermap.org](https://openweathermap.org)

Web элементы используются с:
[https://getbootstrap.com/docs/5.3/getting-started/introduction/](https://getbootstrap.com/docs/5.3/getting-started/introduction/)

Получение текущей погоды:
[https://openweathermap.org/current](https://openweathermap.org/current)

Получение проогноза погоды каждые 3 часа:
[https://openweathermap.org/forecast5](https://openweathermap.org/forecast5)

Шаблонизатор:
[https://www.thymeleaf.org/doc/tutorials](https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html)

## Deploy
Для локального запуска выполнить:
docker-compose up

Добавить в Edit configuration/environment variables: path/.env

## Error message
Ошибки сервиса отображаются ввиде модального окна

![Error](/img/error.png)