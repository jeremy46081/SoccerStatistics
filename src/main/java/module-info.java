module soccer.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens soccer.app to javafx.fxml;
    exports soccer.app;
}