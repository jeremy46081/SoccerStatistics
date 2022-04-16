package soccer.app;

import org.junit.jupiter.api.Test;
import soccer.stats.Teams;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for Teams class
 */
class TeamsTest {

    /**
     * Test for possession percentage of a team function
     */
    @Test
    void possession_percentage1() {
        Teams teams = new Teams();
        ArrayList<String> t= new ArrayList<String>();
        t.add("FC BARCELONA");
        t.add("REAL MADRID");
        ArrayList<String> min= new ArrayList<String>();
        min.add("54");
        min.add("36");
        String TEAM="REAL MADRID";
        String team = teams.possession_percentage(t,min,TEAM);
        assertEquals("Possession percentage of REAL MADRID = 40%",team);
    }

    /**
     * 2nd test for possession percentage of a team function
     */
    @Test
    void possession_percentage2() {
        Teams teams = new Teams();
        ArrayList<String> t= new ArrayList<String>();
        t.add("FC BARCELONA");
        t.add("REAL MADRID");
        ArrayList<String> min= new ArrayList<String>();
        min.add("54");
        min.add("36");
        String TEAM="FC BARCELONA";
        String team = teams.possession_percentage(t,min,TEAM);
        assertEquals("Possession percentage of FC BARCELONA = 60%",team);
    }

    /**
     * Test for possession percentage of a team function if the team does not exist
     */
    @Test
    void possession_percentage3() {
        Teams teams = new Teams();
        ArrayList<String> t= new ArrayList<String>();
        t.add("FC BARCELONA");
        t.add("REAL MADRID");
        ArrayList<String> min= new ArrayList<String>();
        min.add("54");
        min.add("36");
        String TEAM="MAN UTD";
        String team = teams.possession_percentage(t,min,TEAM);
        assertEquals("Team not found!",team);
    }


}