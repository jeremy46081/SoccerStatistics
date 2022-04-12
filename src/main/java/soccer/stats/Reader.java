package soccer.stats;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to assist reading the file
 */
public class Reader {

    /**
     * Opens the given file, reads and gives the names of the teams
     *
     * @param stats file containing game data
     * @return team names
     */
    public ArrayList<String> team(File stats) {
        try {
            String teams = Files.readAllLines(Paths.get(String.valueOf(stats))).get(0);
            String[] team = teams.split(",");
            ArrayList<String> t = new ArrayList<>(Arrays.asList(team));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Opens the given file, reads and gives the names of the players
     *
     * @param stats file containing game data
     * @return player names
     */
    public ArrayList<ArrayList<String>> players(File stats) {
        try {
            String players1 = Files.readAllLines(Paths.get(String.valueOf(stats))).get(1);
            String players2 = Files.readAllLines(Paths.get(String.valueOf(stats))).get(2);
            String[] P1a = players1.split(",");
            String[] P2b = players2.split(",");
            ArrayList<String> P1 = new ArrayList<String>(Arrays.asList(P1a));
            ArrayList<String> P2 = new ArrayList<String>(Arrays.asList(P2b));
            ArrayList<ArrayList<String>> P = new ArrayList<ArrayList<String>>();
            P.add(P1);
            P.add(P2);
            return P;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Opens the given file, reads and gives the goals/assists/fouls
     *
     * @param stats file containing game data
     * @return wanted data
     */
    public ArrayList<String> stats(File stats, int a) {
        try {
            if (a == 4) {
                String goal_scorers = Files.readAllLines(Paths.get(String.valueOf(stats))).get(3);
                String[] g = goal_scorers.split(",");
                ArrayList<String> Goals = new ArrayList<String>(Arrays.asList(g));
                return Goals;
            } else if (a == 5) {
                String assist = Files.readAllLines(Paths.get(String.valueOf(stats))).get(4);
                String[] at = assist.split(",");
                ArrayList<String> Assists = new ArrayList<String>(Arrays.asList(at));
                return Assists;
            } else if (a == 6) {
                String fouls = Files.readAllLines(Paths.get(String.valueOf(stats))).get(4);
                String[] f = fouls.split(",");
                ArrayList<String> Fouls = new ArrayList<String>(Arrays.asList(f));
                return Fouls;
            } else if (a == 7) {
                String goal_scorers = Files.readAllLines(Paths.get(String.valueOf(stats))).get(3);
                String[] g = goal_scorers.split(",");
                ArrayList<String> Goals = new ArrayList<String>(Arrays.asList(g));
                return Goals;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Opens the given file, reads and gives the number of minutes each team had the ball
     *
     * @param stats file containing game data
     * @return number of minutes each team had the ball
     */
    public ArrayList<String> possession(File stats) {
        try {
            String possession_percentage = Files.readAllLines(Paths.get(String.valueOf(stats))).get(5);
            String[] possession = possession_percentage.split(",");
            ArrayList<String> p = new ArrayList<>(Arrays.asList(possession));
            return p;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
