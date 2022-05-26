module com.example.worldoftitan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires java.sql;

    opens com.example.worldoftitan to javafx.fxml;
    exports com.example.worldoftitan;
    exports com.example.worldoftitan.sql;
    opens com.example.worldoftitan.sql to javafx.fxml;
}