package app.weather.service.impl;

import app.weather.model.Weather;
import app.weather.repository.WeatherRepository;
import app.weather.service.HttpClientService;
import app.weather.service.WeatherService;
import app.weather.service.mapper.ApiMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository weatherRepository;
    private HttpClientService httpClientService;
    private ApiMapper apiMapper;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository,
                              HttpClientService httpClientService,
                              ApiMapper apiMapper) {
        this.weatherRepository = weatherRepository;
        this.httpClientService = httpClientService;
        this.apiMapper = apiMapper;
    }

    public Weather getWeatherFromApi(String nameCity, String user) {
        Weather weather = apiMapper.toModel(httpClientService.getWeatherByName(nameCity));
        weather.setUserNeme(user);
        return weatherRepository.save(weather);
    }

    public List<Weather> getAll() {
        return weatherRepository.findAll();
    }
}
