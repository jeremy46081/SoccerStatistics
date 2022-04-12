package soccer.stats;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class to print the name of the players
 */
public class Players {

    /**
     * Ask for all players of a team to be printed
     *
     * @param Players an arraylist of arraylists of player names of each team
     * @param Teams   an arraylist of team names
     * @param team    takes user-inputted team name
     */

    public String players(ArrayList<ArrayList<String>> Players, ArrayList<String> Teams, String team) {

        ArrayList<String> players1 = new ArrayList<>(Players.get(0));
        ArrayList<String> players2 = new ArrayList<>(Players.get(1));

        String a="";

        if (Objects.equals(team, Teams.get(0))) {
            for (String i : players1) {
                a+=(i.substring(0,i.length()-3))+"\n";
            }



        } else if (Objects.equals(team, Teams.get(1))) {
            for (String k : players2) {
                a+=(k.substring(0,k.length()-3))+"\n";
            }


        }


        return a;
    }

}
