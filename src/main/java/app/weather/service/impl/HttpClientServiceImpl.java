package app.weather.service.impl;

import app.weather.dto.api.Root;
import app.weather.service.HttpClientService;
import app.weather.util.PatternUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

@Service
public class HttpClientServiceImpl implements HttpClientService {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Root getWeatherByName(String cityName) {
        HttpGet request = new HttpGet("https://api.openweathermap.org/data/2.5/weather?q="
                + cityName + "&units=metric&appid=" + PatternUtil.API_KEY);
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return objectMapper.readValue(entity.getContent(), Root.class);
        } catch (IOException e) {
            throw new RuntimeException("Can't get weather by city " + cityName, e);
        }
    }
}

