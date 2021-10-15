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
        BufferedReader weatherFileReader = csvReader.getFileFromResourceAsStream(weatherFile);

        WeatherParser weatherParser = new WeatherParser();

        if (weatherFileReader != null){
            List<WeatherDay> weatherData = weatherParser.parseCSV(weatherFileReader);
        }

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }
}
