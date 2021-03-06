package com.example.worldoftitan;

import com.example.worldoftitan.sql.Sql;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {new Sql().createCharacterTableIfNotExist();
    }

    @FXML
    void btnBestPathClicked(MouseEvent event) {
        ViewInteractor.openScene("BestPath.fxml");
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
        ViewInteractor.openScene("marley_word.fxml");
    }

    @FXML
    void btnPlayClicked(MouseEvent event) {
        ViewInteractor.openScene("play.fxml");
    }

    @FXML
    void btnScoutingMissionClicked(MouseEvent event) {
        ViewInteractor.openScene("HamiltonianCycle.fxml");
    }

    @FXML
    void btnSettingsClicked(MouseEvent event) {

    }

    @FXML
    void btnWallOfMariaClicked(MouseEvent event) {
        ViewInteractor.openScene("wall_of_maria.fxml");
    }
}
