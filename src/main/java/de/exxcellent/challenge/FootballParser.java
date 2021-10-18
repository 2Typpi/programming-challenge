package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FootballParser {
    public List<FootballTeam> footballData;

    public FootballParser() {
        footballData = new ArrayList<FootballTeam>();
    }

    public List<FootballTeam> parseCSV(BufferedReader bufferedReader) {
        try {
            String row;
            int i = 0;
            while ((row = bufferedReader.readLine()) != null) {
                String[] team = row.split(",");
                if(isNumeric(team[5]) && isNumeric(team[6])){
                    footballData.add(new FootballTeam(team[0], Integer.parseInt(team[5]), Integer.parseInt(team[6])));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return footballData;
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
