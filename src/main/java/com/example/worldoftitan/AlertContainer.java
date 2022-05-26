package com.example.worldoftitan;

import javafx.scene.control.Alert;

public class AlertContainer {
    public static void showWarningAlert(String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void showInformationAlert(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
