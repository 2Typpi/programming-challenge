package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballParserTest {

    @Test
    void parseCSV() {
        FootballParser footballParser = new FootballParser();
        List<String> teamList = Arrays.asList("Arsenal,38,26,9,3,79,36,87", "Chelsea,38,17,13,8,66,38,64", "Charlton,38,10,14,14,38,49,44", "Derby,38,8,6,24,33,63,30");

        StringBuilder buffer = new StringBuilder();
        for (String current : teamList) {
            buffer.append(current).append("\n");
        }
        BufferedReader footballReader = new BufferedReader(new StringReader(buffer.toString()));

        List<FootballTeam> footballData = footballParser.parseCSV(footballReader);
        FootballTeam actualTeamOne = footballData.get(0);
        FootballTeam actualTeamTwo = footballData.get(1);
        FootballTeam actualLastTeam = footballData.get(footballData.size() - 1);

        FootballTeam teamOne = new FootballTeam("Arsenal", 79, 36);
        FootballTeam teamTwo = new FootballTeam("Chelsea", 66, 38);
        FootballTeam lastTeam = new FootballTeam("Derby", 33, 62);

        assertEquals(teamOne.getTeamName(), actualTeamOne.getTeamName(), "Teamname was not correct (First Team)");
        assertEquals(teamOne.getGoals(), actualTeamOne.getGoals(), "Goals were not expected (First Team)");
        assertEquals(teamOne.getGoalsAllowed(), actualTeamOne.getGoalsAllowed(), "Goals allowed were not expected (First Team)");

        assertEquals(teamTwo.getTeamName(), actualTeamTwo.getTeamName(), "Teamname was not correct (Second Team)");
        assertEquals(teamTwo.getGoals(), actualTeamTwo.getGoals(), "Goals were not expected (Second Team)");
        assertEquals(teamTwo.getGoalsAllowed(), actualTeamTwo.getGoalsAllowed(), "Goals allowed were not expected (Second Team)");

        assertEquals(lastTeam.getTeamName(), actualLastTeam.getTeamName(), "Teamname was not correct (Last Team)");
        assertEquals(lastTeam.getGoals(), actualLastTeam.getGoals(), "Goals were not expected (Last Team)");
        assertEquals(lastTeam.getGoalsAllowed(), actualLastTeam.getGoalsAllowed(), "Goals allowed were not expected (Last Team)");
    }
}