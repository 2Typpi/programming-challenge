package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherParserTest {

    @Test
    void parseCSVTest() {
        WeatherParser weatherParser = new WeatherParser();
        List<String> weatherList = Arrays.asList("1,50,50,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5", "2,60,40,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5", "3,77,55,66,39.6,0,350,5,350,9,2.8,59,24,1016.8", "4,77,59,68,51.1,0,110,9.1,130,12,8.6,62,40,1021.1");

        StringBuilder buffer = new StringBuilder();
        for (String current : weatherList) {
            buffer.append(current).append("\n");
        }
        BufferedReader weatherReader = new BufferedReader(new StringReader(buffer.toString()));

        List<WeatherDay> weatherData = weatherParser.parseCSV(weatherReader);
        WeatherDay actualDayOne = weatherData.get(0);
        WeatherDay actualDayTwo = weatherData.get(1);
        WeatherDay actualLastDay = weatherData.get(weatherData.size() - 1);

        WeatherDay dayOne = new WeatherDay(1, 50, 50);
        WeatherDay dayTwo = new WeatherDay(2, 60, 40);
        WeatherDay lastDay = new WeatherDay(4, 77, 59);

        assertEquals(dayOne.getDayNumber(), actualDayOne.getDayNumber(), "Day Number was not correct (First Day)");
        assertEquals(dayOne.getMinTemperature(), actualDayOne.getMinTemperature(), "MinTemperature was not expected (First Day)");
        assertEquals(dayOne.getMaxTemperature(), actualDayOne.getMaxTemperature(), "MaxTemperature was not expected (First Day)");

        assertEquals(dayTwo.getDayNumber(), actualDayTwo.getDayNumber(), "Day Number was not correct (Second Day)");
        assertEquals(dayTwo.getMinTemperature(), actualDayTwo.getMinTemperature(), "MinTemperature was not expected (Second Day)");
        assertEquals(dayTwo.getMaxTemperature(), actualDayTwo.getMaxTemperature(), "MaxTemperature was not expected (Second Day)");

        assertEquals(lastDay.getDayNumber(), actualLastDay.getDayNumber(), "Day Number was not correct (Last Day)");
        assertEquals(lastDay.getMinTemperature(), actualLastDay.getMinTemperature(), "MinTemperature was not expected (Last Day)");
        assertEquals(lastDay.getMaxTemperature(), actualLastDay.getMaxTemperature(), "MaxTemperature was not expected (Last Day)");
    }
}