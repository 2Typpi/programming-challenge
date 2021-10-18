package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WeatherParser {
    public List<WeatherDay> weatherData;

    public WeatherParser() {
        weatherData = new ArrayList<WeatherDay>();
    }

    public List<WeatherDay> parseCSV(BufferedReader bufferedReader) {
        try {
            String row;
            int i = 0;
            while ((row = bufferedReader.readLine()) != null) {
                String[] day = row.split(",");
                if(isNumeric(day[0]) && isNumeric(day[1]) && isNumeric(day[2])){
                    weatherData.add(new WeatherDay(Integer.parseInt(day[0]), Integer.parseInt(day[1]), Integer.parseInt(day[2])));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherData;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
