package app.weather.dto.api;

import lombok.Data;

@Data
public class Root {
    private Main main;
    private Wind wind;
    private String name;
}
