package soccer.stats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class to calculate the player statistics of the game
 */
public class PlayerStats {
    /**
     * asks for no. of goals scored by a player in each team
     *
     * @param Goals an arraylist containing players who scored goals
     */
    public void number_of_goals(ArrayList<String> Goals) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player's name: ");
        String player = scanner.nextLine();
        int c = 0;
        for (String k : Goals) {
            if (Objects.equals(player, k)) {
                c += 1;
            }
        }
        if (c != 0) {
            System.out.println("Number of goals scored by " + player + "=" + c);
            System.out.println("Success!");
        } else {
            System.out.println(player + " has not scored any goals");
        }
    }

    /**
     * asks for player who scored the highest number of goals
     *
     * @param Goals an arraylist containing players who scored goals
     */
    public String highest_goal_scorer(ArrayList<String> Goals) {
        String highest = null;

        int c = Goals.size();
        for (int i = 0; i < c - 1; i++) {
            if (Collections.frequency(Goals, Goals.get(i)) > Collections.frequency(Goals, Goals.get(i + 1))) {
                highest = Goals.get(i);

            }

        }
        return("The top goal scorer is: " +highest+"\nNo. of Goals: "+Collections.frequency(Goals,highest ));

    }

    /**
     * Asks for no. of fouls committed by a player
     *
     * @param Fouls arraylist containing players who committed a foul
     */
    public String number_of_fouls(ArrayList<String> Fouls, String player) {
        int c = 0;
        for (String k : Fouls) {
            if (Objects.equals(player, k)) {
                c += 1;
            }
        }
        if (c != 0) {
            return("Number of fouls committed by " + player + "=" + c);

        } else {
            return(player + " has not committed any fouls");
        }
    }

}



