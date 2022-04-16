package soccer.app;

import org.junit.jupiter.api.Test;
import soccer.stats.PlayerStats;



import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test for PlayerStats class
 */
class PlayerStatsTest {

    @Test
    /**
     * Test for highest goalscorer function
     */

    void highest_goal_scorer() {
        PlayerStats stats=new PlayerStats();
        ArrayList<String> Goals=new ArrayList<String>();
        Goals.add("Benzema");
        Goals.add("Vinicius");
        Goals.add("Benzema");
        Goals.add("Aubameyang");
        String pstats=stats.highest_goal_scorer(Goals);
        assertEquals("The top goal scorer is: Benzema\nNo. of Goals: 2",pstats);

    }



    @Test
    /**
     * Test for no. of fouls committed by a player function
     */
    void number_of_fouls1() {
        PlayerStats stats=new PlayerStats();
        ArrayList<String> Fouls= new ArrayList<String>();
        Fouls.add("Nacho");
        Fouls.add("Pique");
        Fouls.add("Nacho");
        Fouls.add("Modric");
        String player="Nacho";
        String foul=stats.number_of_fouls(Fouls,player);
        assertEquals("Number of fouls committed by Nacho=2",foul);

    }

    @Test
    /**
     * 2nd test for no. of fouls committed by a player function
     */
    void number_of_fouls2() {
        PlayerStats stats=new PlayerStats();
        ArrayList<String> Fouls= new ArrayList<String>();
        Fouls.add("Nacho");
        Fouls.add("Pique");
        Fouls.add("Nacho");
        Fouls.add("Modric");
        String player="Pique";
        String foul=stats.number_of_fouls(Fouls,player);
        assertEquals("Number of fouls committed by Pique=1",foul);

    }

    @Test
    /**
     * Test for no. of fouls committed by a player function if a player has not committed any fouls
     */
    void number_of_fouls3() {
        PlayerStats stats=new PlayerStats();
        ArrayList<String> Fouls= new ArrayList<String>();
        Fouls.add("Nacho");
        Fouls.add("Pique");
        Fouls.add("Nacho");
        Fouls.add("Modric");
        String player="Benzema";
        String foul=stats.number_of_fouls(Fouls,player);
        assertEquals("Benzema has not committed any fouls",foul);

    }


}