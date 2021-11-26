package app.weather.service.mapper;

import app.weather.dto.model.WeatherResponseDto;
import app.weather.model.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherResponseDto toDto(Weather weather) {
        WeatherResponseDto responseDto = new WeatherResponseDto();
        responseDto.setNameCity(weather.getNameCity());
        responseDto.setTemp(weather.getTemp());
        responseDto.setWindSpeed(weather.getWindSpeed());
        return responseDto;
    }
}
