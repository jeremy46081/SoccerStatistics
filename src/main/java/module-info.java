module soccer.app {
    requires javafx.controls;
    requires javafx.fxml;



    opens soccer.app to javafx.fxml;
    exports soccer.app;
}