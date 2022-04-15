import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamsTest {



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