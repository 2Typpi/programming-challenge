package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String weatherFile = "de/exxcellent/challenge/weather.csv";
        String footballFile = "de/exxcellent/challenge/football.csv";

        // Init all Objects
        IReader csvReader = new CSVReader();
        WeatherParser weatherParser = new WeatherParser();
        FootballParser footballParser = new FootballParser();
        TemperatureDistributionCalculator temperatureDistributionCalculator = new TemperatureDistributionCalculator();

        BufferedReader weatherFileReader = csvReader.getFileFromResourceAsStream(weatherFile);
        List<WeatherDay> weatherData = null;
        if (weatherFileReader != null){
            weatherData = weatherParser.parseCSV(weatherFileReader);
        } else {
            System.err.println("Couldn't read the file");
            return;
        }
        WeatherDay dayWithSmallestTempSpread = null;
        if (weatherData != null) {
            dayWithSmallestTempSpread = temperatureDistributionCalculator.findMinTemperatureSpread(weatherData);
        } else {
            System.err.println("No Data found in the file");
            return;
        }

        if (dayWithSmallestTempSpread != null) {
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread.getDayNumber());
        }

        BufferedReader footballFileReader = csvReader.getFileFromResourceAsStream(footballFile);
        List<FootballTeam> footballData = null;
        if (footballFileReader != null){
            footballData = footballParser.parseCSV(footballFileReader);
        } else {
            System.err.println("Couldn't read the file");
            return;
        }

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
