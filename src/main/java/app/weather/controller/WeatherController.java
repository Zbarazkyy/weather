package app.weather.controller;

import app.weather.dto.model.WeatherResponseDto;
import app.weather.service.WeatherService;
import app.weather.service.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private WeatherService weatherService;
    private WeatherMapper weatherMapper;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherMapper weatherMapper) {
        this.weatherService = weatherService;
        this.weatherMapper = weatherMapper;
    }

    @GetMapping("/get-weather")
    public WeatherResponseDto getWeather(@RequestParam String nameCity, Authentication auth) {
        return weatherMapper.toDto(weatherService.getWeatherFromApi(nameCity, auth.getName()));
    }
}
