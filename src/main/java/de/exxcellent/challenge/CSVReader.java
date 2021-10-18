package de.exxcellent.challenge;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CSVReader implements IReader {

    public CSVReader() {

    }

    public BufferedReader getFileFromResourceAsStream(String fileName) {
        BufferedReader csvReader = null;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            try {
                File resourceFile = new File(resource.toURI());
                csvReader = new BufferedReader(new FileReader(resourceFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return csvReader;
    }
}
