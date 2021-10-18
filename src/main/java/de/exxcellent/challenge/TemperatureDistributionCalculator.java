package de.exxcellent.challenge;

import java.util.List;

import static java.lang.Math.abs;

public class TemperatureDistributionCalculator {

    public TemperatureDistributionCalculator() {
    }

    public WeatherDay findMinTemperatureSpread(List<WeatherDay> weatherData) {
        int currentLowestSpread = Integer.MAX_VALUE;
        WeatherDay currentLowestSpreadDay = null;
        for(WeatherDay currentDay : weatherData){
            int temperatureSpread = currentDay.getMaxTemperature() - currentDay.getMinTemperature();
            if (currentLowestSpread >= abs(temperatureSpread)) {
                currentLowestSpread = abs(temperatureSpread);
                currentLowestSpreadDay = currentDay;
            }
        }
        return currentLowestSpreadDay;
    }
}
