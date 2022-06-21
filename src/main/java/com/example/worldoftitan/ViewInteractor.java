package com.example.worldoftitan;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewInteractor {
    public static Stage stage;

    public static void openScene(String fxmlFileName) {
        try {
            tryToOpenScene(fxmlFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void tryToOpenScene(String fxmlFileName) throws IOException {

//        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
//        stage.setScene(new Scene(root));
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("file:/C:/Users/user/Documents/IntellijProjects/WIA%201002%20Data%20Structure/Attack-On-Titan-GUI/src/main/stylesheet/style.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
