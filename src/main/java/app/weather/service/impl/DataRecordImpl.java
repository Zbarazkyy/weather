package app.weather.service.impl;

import app.weather.model.Weather;
import app.weather.service.DataRecord;
import app.weather.service.WeatherService;
import app.weather.util.PatternUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DataRecordImpl implements DataRecord {
    private WeatherService weatherService;

    public DataRecordImpl(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(cron = "0 05 18 1/1 * ?")
    @Override
    public void recordDateFromDb() {
        List<Weather> weatherList = weatherService.getAll();
        File file = new File(PatternUtil.PATH_TO_FILE);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
            for (Weather s : weatherList) {
                out.write("Time - " + s.getTimeRequest().toString());
                out.write(" : ");
                out.write(" User - " + s.getUserNeme());
                out.write(" : ");
                out.write(" City -  " + s.getNameCity());
                out.write(" : ");
                out.write(" Temp - " + s.getTemp());
                out.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't record backup from DB");
        }
        log.info("hello pavel");
    }
}
