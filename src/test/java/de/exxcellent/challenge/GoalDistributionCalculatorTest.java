package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoalDistributionCalculatorTest {

    @Test
    void findMinGoalSpreadTest() {
        FootballTeam teamOne = new FootballTeam("Arsenal", 79,36);
        FootballTeam teamTwo = new FootballTeam("Chelsea", 66,38);
        FootballTeam teamThree = new FootballTeam("Charlton", 38,49);
        FootballTeam lastTeam = new FootballTeam("Derby", 33, 63);

        List<FootballTeam> footballData = new ArrayList();
        footballData.add(teamOne);
        footballData.add(teamTwo);
        footballData.add(teamThree);
        footballData.add(lastTeam);

        GoalDistributionCalculator goalDistributionCalculator = new GoalDistributionCalculator();
        WeatherDay teanWithMinGoalSpread = goalDistributionCalculator.findMinGoalSpread(footballData);

        assertEquals(teamTwo.getTeamName(), teanWithMinGoalSpread.getTeamName(), "Team with Minimal Goal Spread not found");
    }
}