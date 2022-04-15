package soccer.stats;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * Class to calculate the statistics of each team
 */
public class Teams {

    /**
     * Asks for team names to be printed
     *
     * @param Teams an arraylist of team names
     */

    public String teamname(ArrayList<String> Teams) {

        for (String i : Teams) {
            return i;
        }

        return null;
    }

    /**
     * Asks for possession percentage of a team during the game
     *
     * @param Teams   an arraylist of team names
     * @param minutes arraylist of minutes each team had the ball
     */
    public String possession_percentage(ArrayList<String> Teams, ArrayList<String> minutes, String team) {
        if (Objects.equals(team, Teams.get(0))) {
            double e = (parseInt(minutes.get(0))) / 90.0;
            double a = (e) * 100;
            return("Possession percentage of " + Teams.get(0) + " = " + Math.round(a) + "%");

        } else if (Objects.equals(team, Teams.get(1))) {
            double e = (parseInt(minutes.get(1))) / 90.0;
            double a = (e) * 100;
            return("Possession percentage of " + Teams.get(1) + " = " + Math.round(a) + "%");

        } else {
            return("Team not found!");
        }


    }


}
