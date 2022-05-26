package com.example.worldoftitan;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class StartController {

    @FXML
    void btnBestPathClicked(MouseEvent event) {

    }

    @FXML
    void btnCharactersClicked(MouseEvent event) {
        ViewInteractor.openScene("character.fxml");
    }

    @FXML
    void btnExitClicked(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    void btnMarleyWordClicked(MouseEvent event) {

    }

    @FXML
    void btnPlayClicked(MouseEvent event) {

    }

    @FXML
    void btnScoutingMissionClicked(MouseEvent event) {

    }

    @FXML
    void btnSettingsClicked(MouseEvent event) {

    }

    @FXML
    void btnWallOfMariaClicked(MouseEvent event) {

    }
}
