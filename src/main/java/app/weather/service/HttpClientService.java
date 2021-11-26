package app.weather.service;

import app.weather.dto.api.Root;

public interface HttpClientService {
    public Root getWeatherByName(String cityName);
}
