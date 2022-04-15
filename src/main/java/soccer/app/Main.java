package soccer.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Main extends Application {


    public void main(String[] args) {
        if (args.length==1){
            File stats = new File(args[0]);
        }

        launch(args);

    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("soccerstats.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        //Students edit here to set up the scene
        stage.setScene(scene);
        stage.setTitle("Soccer Statistics");
        stage.show();
    }
}