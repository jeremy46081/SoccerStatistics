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
    private TextArea Details;


    @FXML
    private TextField PlayerName;

    @FXML
    private TextField PlayerTeam;

    @FXML
    private TextField Teamposssession;


    @FXML
    private TextField allPlayersTeam;

    @FXML
    private TextField foulsPlayer;

    @FXML
    private TextField foulsPlayerName;

    @FXML
    private TextField goalsPlayer;


    @FXML
    private TextField pTeam1;

    @FXML
    private TextField pTeam2;

    @FXML
    private ChoiceBox<String> playerPosition;


    @FXML
    private TextField removePlayerName;

    @FXML
    private TextField removePlayerTeam;

    @FXML
    private TextField team1;

    @FXML
    private TextField team2;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;



    ObservableList<String> positionlist= FXCollections.observableArrayList("GKP","DEF","MID","ATK");


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


    @FXML
    void aboutstats(ActionEvent event) {
        Alert about=new Alert(Alert.AlertType.INFORMATION,"Author: Jessica Thomas & Jeremy Thomas\n"+"Email: jessica.thomas1@ucalgary.ca\t jeremy.thomas1@ucalgary.ca\n"+"Version: v1.0\n"+"This is a program for viewing the statistics of a soccer game.\n");
        about.show();
    }

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

    @FXML
    void possesionpercent(ActionEvent event) {
        if (Teamposssession.getText()!="") {

            min.add(pTeam1.getText());
            min.add(pTeam2.getText());
            System.out.println(teams);
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
}