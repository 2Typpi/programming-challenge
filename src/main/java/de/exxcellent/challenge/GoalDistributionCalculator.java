package de.exxcellent.challenge;

import java.util.List;

import static java.lang.Math.abs;

public class GoalDistributionCalculator {

    public GoalDistributionCalculator() {
    }

    public FootballTeam findMinGoalSpread(List<FootballTeam> footballData) {
        int lowestGoalSpread = Integer.MAX_VALUE;
        FootballTeam lowestGoalSpreadTeam = null;
        for (FootballTeam currentTeam : footballData) {
            int currentSpread = currentTeam.getGoals() - currentTeam.getGoalsAllowed();
            if (lowestGoalSpread > abs(currentSpread)) {
                lowestGoalSpread = abs(currentSpread);
                lowestGoalSpreadTeam = currentTeam;
            }
        }
        return lowestGoalSpreadTeam;
    }
}
