package app.weather.dto.model;

import lombok.Data;

@Data
public class WeatherResponseDto {
    private String nameCity;
    private int temp;
    private double windSpeed;
}
