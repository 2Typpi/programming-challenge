package de.exxcellent.challenge;

import java.io.BufferedReader;

public interface IReader {
    public BufferedReader getFileFromResourceAsStream(String fileName);
}
