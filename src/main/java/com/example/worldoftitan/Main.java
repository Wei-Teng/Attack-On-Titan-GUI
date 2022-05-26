package com.example.worldoftitan;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UNDECORATED);
        ViewInteractor.stage = stage;
        ViewInteractor.openScene("start.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}