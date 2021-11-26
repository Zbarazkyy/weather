package app.weather.service.mapper;

import app.weather.dto.api.Root;
import app.weather.model.Weather;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class ApiMapper {

    public Weather toModel(Root root) {
        Weather weather = new Weather();
        weather.setNameCity(root.getName());
        weather.setWindSpeed(root.getWind().getSpeed());
        weather.setTemp((int) root.getMain().getTemp());
        weather.setTimeRequest(LocalDateTime.now());
        return weather;
    }
}
