package de.exxcellent.challenge;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CSVReader implements IReader {

    public CSVReader() {

    }

    public BufferedReader getFileFromResourceAsStream(String fileName) {

        BufferedReader csvReader = null;
        File csvFile = new File(fileName);
        if (csvFile.isFile()) {
            try {
                csvReader = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return csvReader;
    }
}
