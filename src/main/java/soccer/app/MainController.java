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


    ObservableList<String> positionlist = FXCollections.observableArrayList("GKP", "DEF", "MID", "ATK");


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
    ArrayList<String> listoffouls = new ArrayList<>();
    ArrayList<String> listofgoals = new ArrayList<>();
    ArrayList<String> min = new ArrayList<String>();
    Players play = new Players();
    ArrayList<String> listofplayers1 = new ArrayList<>();
    ArrayList<String> listofplayers2 = new ArrayList<>();
    ArrayList<ArrayList<String>> allplayers = new ArrayList<>();
    Reader reader = new Reader();


    @FXML
    void aboutstats(ActionEvent event) {
        Alert about = new Alert(Alert.AlertType.INFORMATION, "Author: Jessica Thomas & Jeremy Thomas\n" + "Email: jessica.thomas1@ucalgary.ca\t jeremy.thomas1@ucalgary.ca\n" + "Version: v1.0\n" + "This is a program for viewing the statistics of a soccer game.\n");
        about.show();
    }
}