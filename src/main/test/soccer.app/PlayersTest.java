package soccer.app;

import org.junit.jupiter.api.Test;
import soccer.stats.Players;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test for Players class
 */
class PlayersTest {

    @Test
    /**
     * Test for view all players of a team function
     */
    void players() {
        Players players=new Players();
        ArrayList<ArrayList<String>> Players= new ArrayList<ArrayList<String>>();
        ArrayList<String> p1=new ArrayList<String>((Arrays.asList("Ter StegenGKP","AraujoDEF","PiqueDEF","GarciaDEF","AlbaDEF","BusquetsMID","De JongMID","PedriMID","Ferran TorresATK","AubameyangATK","DembeleATK")));
        ArrayList<String> p2=new ArrayList<String>((Arrays.asList("CourtoisGKP","CarvajalDEF","AlabaDEF","MilitaoDEF","NachoDEF","KroosMID","CasemiroMID","ModricMID","Fede ValverdeATK","BenzemaATK","ViniciusATK")));
        Players.add(p1);
        Players.add(p2);
        ArrayList<String> team=new ArrayList<String>(Arrays.asList("FC BARCELONA","REAL MADRID"));
        String t="FC BARCELONA";
        String player=players.players(Players,team,t);
        assertEquals("Ter Stegen\nAraujo\nPique\nGarcia\nAlba\nBusquets\nDe Jong\nPedri\nFerran Torres\nAubameyang\nDembele\n",player);
    }
}