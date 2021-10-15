package de.exxcellent.challenge;

public class WeatherDay {
    int dayNumber;
    int maxTemperature;
    int minTemperature;

    public WeatherDay(int dayNumber, int maxTemp, int minTemp) {
        this.dayNumber = dayNumber;
        this.maxTemperature = maxTemp;
        this.minTemperature = minTemp;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }
}
