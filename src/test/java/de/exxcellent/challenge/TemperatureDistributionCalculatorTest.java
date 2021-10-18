package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureDistributionCalculatorTest {

    @Test
    void findMinTemperatureSpreadTest() {
        WeatherDay dayOne = new WeatherDay(1, 88,59);
        WeatherDay dayTwo = new WeatherDay(2, 79,63);
        WeatherDay dayThree = new WeatherDay(3, 77,55);
        WeatherDay lastDay = new WeatherDay(4, 77, 59);

        List<WeatherDay> weatherData = new ArrayList();
        weatherData.add(dayOne);
        weatherData.add(dayTwo);
        weatherData.add(dayThree);
        weatherData.add(lastDay);

        TemperatureDistributionCalculator temperatureDistributionCalculator = new TemperatureDistributionCalculator();
        WeatherDay dayOfMinTemperatureSpread = temperatureDistributionCalculator.findMinTemperatureSpread(weatherData);

        assertEquals(dayTwo.getDayNumber(), dayOfMinTemperatureSpread.getDayNumber(), "Day with Minimal Temperature Spread not found");
    }

    @Test
    void shouldFindMinTemperatureSpreadMinNegativeTest() {
        WeatherDay dayOne = new WeatherDay(1, 5,-8);
        WeatherDay dayTwo = new WeatherDay(2, 79,63);
        WeatherDay dayThree = new WeatherDay(3, 77,55);
        WeatherDay lastDay = new WeatherDay(4, 77, 59);

        List<WeatherDay> weatherData = new ArrayList();
        weatherData.add(dayOne);
        weatherData.add(dayTwo);
        weatherData.add(dayThree);
        weatherData.add(lastDay);

        TemperatureDistributionCalculator temperatureDistributionCalculator = new TemperatureDistributionCalculator();
        WeatherDay dayOfMinTemperatureSpread = temperatureDistributionCalculator.findMinTemperatureSpread(weatherData);

        assertEquals(dayOne.getDayNumber(), dayOfMinTemperatureSpread.getDayNumber(), "Day with Minimal Temperature Spread not found");
    }

    @Test
    void shouldFindMinTemperatureSpreadDoubleNegativeTest() {
        WeatherDay dayOne = new WeatherDay(1, 5,-8);
        WeatherDay dayTwo = new WeatherDay(2, 79,63);
        WeatherDay dayThree = new WeatherDay(3, -5,-9);
        WeatherDay lastDay = new WeatherDay(4, 77, 59);

        List<WeatherDay> weatherData = new ArrayList();
        weatherData.add(dayOne);
        weatherData.add(dayTwo);
        weatherData.add(dayThree);
        weatherData.add(lastDay);

        TemperatureDistributionCalculator temperatureDistributionCalculator = new TemperatureDistributionCalculator();
        WeatherDay dayOfMinTemperatureSpread = temperatureDistributionCalculator.findMinTemperatureSpread(weatherData);

        assertEquals(dayThree.getDayNumber(), dayOfMinTemperatureSpread.getDayNumber(), "Day with Minimal Temperature Spread not found");
    }
}