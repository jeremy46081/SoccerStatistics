package soccer.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import soccer.stats.PlayerStats;
import soccer.stats.Players;
import soccer.stats.Reader;
import soccer.stats.Teams;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

import static javafx.application.Platform.exit;

public class MainController {


    @FXML
    private TextArea Details; //Show details & statistics that is asked by the user


    @FXML
    private TextField PlayerName; //Stores the name of the player

    @FXML
    private TextField PlayerTeam; //Stores the name of the team the player is in

    @FXML
    private TextField Teamposssession; //User inputs the team which they want to view the possession percentage of


    @FXML
    private TextField allPlayersTeam; //User inputs the team which they want to view all the players of

    @FXML
    private TextField foulsPlayer; //User adds a player which commited a foul

    @FXML
    private TextField foulsPlayerName; //User inputs the player of which they want to see the no. of fouls committed

    @FXML
    private TextField goalsPlayer; //User adds a player which scored a goal

    @FXML
    private TextField pTeam1; //Stores no. of minutes the 1st team had the ball

    @FXML
    private TextField pTeam2; //Stores no. of minutes the 2nd team had the ball

    @FXML
    private ChoiceBox<String> playerPosition; //Choice box containing different positions a player can have


    @FXML
    private TextField removePlayerName; //Stores name of the player the user wants to remove

    @FXML
    private TextField removePlayerTeam; //Stores team of the player the user wants to remove

    @FXML
    private TextField team1; //Stores the name of 1st team

    @FXML
    private TextField team2;  //Stores the name of 2nd team

    @FXML
    private Label leftStatus;  //Outputs current status of the program

    @FXML
    private Label rightStatus; //Outputs errors and issues caused by the user



    ObservableList<String> positionlist= FXCollections.observableArrayList("GKP","DEF","MID","ATK"); //Collection of player positions in the choice box


    /**
     * Setup the window state
     */
    @FXML
    public void initialize() {


        playerPosition.setItems(positionlist);
    }
    ArrayList<String> teams = new ArrayList<>();
    Teams team = new Teams();
    PlayerStats fouls = new PlayerStats();
    PlayerStats goals = new PlayerStats();
    ArrayList<String> listoffouls= new ArrayList<>();
    ArrayList<String> listofgoals= new ArrayList<>();
    ArrayList<String> min = new ArrayList<String>();
    Players play = new Players();
    ArrayList<String> listofplayers1 = new ArrayList<>();
    ArrayList<String> listofplayers2 = new ArrayList<>();
    ArrayList<ArrayList<String>> allplayers = new ArrayList<>();
    Reader reader= new Reader();


    /**
     * Alerts with info about the program
     * @param event
     */
    @FXML
    void aboutstats(ActionEvent event) {
        Alert about=new Alert(Alert.AlertType.INFORMATION,"Author: Jessica Thomas & Jeremy Thomas\n"+"Email: jessica.thomas1@ucalgary.ca\t jeremy.thomas1@ucalgary.ca\n"+"Version: v1.0\n"+"This is a program for viewing the statistics of a soccer game.\n");
        about.show();
    }

    /**
     * Loads an already existing file
     * @param event
     */
    @FXML
    void loadFile(ActionEvent event) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        File fileload=fileChooser.showOpenDialog(new Stage());
        teams=(reader.team(fileload));
        for (String i:(reader.stats(fileload,6))){
            listoffouls.add(i.substring(0,i.length()-3));
        }
        for (String k:(reader.stats(fileload,4))){
            listofgoals.add(k.substring(0,k.length()-3));
        }
        for (String a:(reader.players(fileload)).get(0)){

                listofplayers1.add(a);
        }
        for (String b:(reader.players(fileload)).get(1)){

            listofplayers2.add(b);
        }
        allplayers.add(listofplayers1);
        allplayers.add(listofplayers2);
        team1.setText(teams.get(0));
        team2.setText(teams.get(1));

        min=(reader.possession(fileload));
        pTeam1.setText(min.get(0));
        pTeam2.setText(min.get(1));
        rightStatus.setText("File loaded!");

    }

    /**
     * Saves the world as a txt file
     * @param event
     * @throws IOException
     */
    @FXML
    void saveFile(ActionEvent event) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        File fileSave = fileChooser.showSaveDialog(new Stage());
        PrintWriter Writer = new PrintWriter(fileSave+".txt", StandardCharsets.UTF_8);
        String a = String.join(",",teams);
        Writer.println(a);
        Writer.println(String.join(",",listofplayers1));
        Writer.println(String.join(",",listofplayers2));
        Writer.println(String.join(",",listofgoals));
        Writer.println(String.join(",",listoffouls));
        Writer.println(String.join(",",min));
        Writer.close();
        rightStatus.setText("File saved!");
    }

    /**
     * Creates an arraylist of team names and displays it
     * @param event
     */
    @FXML
    void addTeamName(ActionEvent event) {

        if (team1.getText()!="" && team2.getText()!="" && pTeam1.getText()!="" && pTeam2.getText()!=""){
            teams.add(team1.getText());
            teams.add(team2.getText());
            String t = team.teamname(teams);
            Details.setText(teams.get(0)+"\n"+teams.get(1));
            leftStatus.setText("Teams added!");
            rightStatus.setText(null);
        }
        else{

            rightStatus.setText("Team info not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);

        }

    }

    /**
     * Displays possession percentage of a team during the game
     * @param event
     */
    @FXML
    void possesionpercent(ActionEvent event) {
        if (Teamposssession.getText()!="") {

            min.add(pTeam1.getText());
            min.add(pTeam2.getText());

            Details.appendText(team.possession_percentage(teams, min, Teamposssession.getText()));
            leftStatus.setText("Possession percentage displayed!");
            rightStatus.setText(null);
        }
        else{
            rightStatus.setText("Team name not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);

        }

    }

    /**
     * Creates an arraylist of players who committed a foul
     * @param event
     */
    @FXML
    void addFouls(ActionEvent event) {
        if (foulsPlayer.getText()!="") {
            listoffouls.add(foulsPlayer.getText());
            leftStatus.setText("Foul added!");
            rightStatus.setText(null);
        }
        else{
            rightStatus.setText("Player name not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);


        }

    }

    /**
     * Displays number of fouls committed by a player
     * @param event
     */
    @FXML
    void showFouls(ActionEvent event) {
        if (foulsPlayerName.getText()!=""){
            String a=fouls.number_of_fouls(listoffouls,foulsPlayerName.getText());
            Details.setText(a);
            leftStatus.setText("Fouls shown!");
            rightStatus.setText(null);
        }
        else{
            rightStatus.setText("Player name not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }

    }

    /**
     * Creates an arraylist of players who scored a goal
     * @param event
     */
    @FXML
    void addGoals(ActionEvent event) {
        if (goalsPlayer.getText()!=""){
            listofgoals.add(goalsPlayer.getText());
            leftStatus.setText("Goal added!");
            rightStatus.setText(null);

        }
        else{
            rightStatus.setText("Player name not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }

    }

    /**
     * Displays the player who scored the highest number of goals in the game
     * @param event
     */
    @FXML
    void showGoals(ActionEvent event) {
        if (listofgoals!=null){
            String b=goals.highest_goal_scorer(listofgoals);
            Details.setText(b);
            leftStatus.setText("Goals shown!");
            rightStatus.setText(null);
        }
        else{
            rightStatus.setText("No goals have been scored!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }


    }

    /**
     * Adds players along with their information to an arraylist of players
     * @param event
     */
    @FXML
    void addPlayer(ActionEvent event) {
        if (PlayerTeam.getText()!="" && PlayerName.getText()!=""){
            if (Objects.equals(PlayerTeam.getText(), team1.getText()) || Objects.equals(PlayerTeam.getText(), team2.getText())){
                if (Objects.equals(PlayerTeam.getText(), team1.getText())){
                    listofplayers1.add(PlayerName.getText()+playerPosition.getValue());
                }
                else {
                    listofplayers2.add(PlayerName.getText()+playerPosition.getValue());
                }
                leftStatus.setText("Player added!");
                rightStatus.setText(null);

            }
            else{
                rightStatus.setText("Team information incorrect!");
                rightStatus.setTextFill(Color.RED);
                leftStatus.setText(null);
            }


        }
        else{
            rightStatus.setText("Player information not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }

    }

    /**
     * views all players of a team specified by the user
     * @param event
     */
    @FXML
    void viewPlayers(ActionEvent event){
        if (!Objects.equals(allPlayersTeam.getText(), "")){
            if(Objects.equals(allPlayersTeam.getText(), team1.getText()) || Objects.equals(allPlayersTeam.getText(), team2.getText())){
                allplayers.add(listofplayers1);
                allplayers.add(listofplayers2);
                String tname = allPlayersTeam.getText();
                Details.setText(play.players(allplayers, teams, tname));
                leftStatus.setText("Players Shown!");
                rightStatus.setText(null);
            }
            else{
                rightStatus.setText("Team does not exist!");
                rightStatus.setTextFill(Color.RED);
                leftStatus.setText(null);
            }


        }
        else{
            rightStatus.setText("Team not inputted!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }




    }

    /**
     * Removes a player from a team which are both chosen by the user
     * @param event
     */


    @FXML
    void removePlayer(ActionEvent event){

        if (Objects.equals(removePlayerTeam.getText(), team1.getText())){
            String a = null;

            for (String i:listofplayers1) {

                if (Objects.equals(i.substring(0, i.length() - 3), removePlayerName.getText())) {
                    a=i;
                }
            }
            listofplayers1.remove(a);
            leftStatus.setText("Player Removed!");
            rightStatus.setText(null);
        } else if (Objects.equals(removePlayerTeam.getText(), team2.getText())) {
            String b=null;
            for (String k : listofplayers2) {

                if (Objects.equals(k.substring(0,k.length()-3), removePlayerName.getText())) {
                    b=k;
                }

            }
            listofplayers2.remove(b);
            leftStatus.setText("Player Removed!");
            rightStatus.setText(null);

        }
        else{
            rightStatus.setText("Team does not exist!");
            rightStatus.setTextFill(Color.RED);
            leftStatus.setText(null);
        }
        Details.setText(null);
    }

    /**
     * exits from the program
     * @param event
     */
    @FXML
    void quitProgram(ActionEvent event) {
        exit();
    }
}