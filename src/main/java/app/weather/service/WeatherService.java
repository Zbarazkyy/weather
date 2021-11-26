package app.weather.service;

import app.weather.model.Weather;
import java.util.List;

public interface WeatherService {
    Weather getWeatherFromApi(String nameCity, String user);

    List<Weather> getAll();
}
