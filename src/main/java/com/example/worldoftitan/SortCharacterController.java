package com.example.worldoftitan;

import com.example.worldoftitan.sql.Sql;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class SortCharacterController implements Initializable {

    @FXML
    private ChoiceBox<String> attributeChoiceBox;
    @FXML
    private ImageView designImageView1;
    @FXML
    private ImageView designImageView2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File picture1 = new File("C:\\Users\\Admin\\IdeaProjects\\WorldOfTitan\\Images\\aot_trio_cute.jpg");
        designImageView1.setImage(new Image(picture1.toURI().toString()));

        File picture2 = new File("C:\\Users\\Admin\\IdeaProjects\\WorldOfTitan\\Images\\levi_cleaner.jpg");
        designImageView2.setImage(new Image(picture2.toURI().toString()));
        attributeChoiceBox.setItems(FXCollections.observableArrayList("Height", "Weight", "Strength",
                "Agility", "Intelligence", "Coordination", "Leadership"));
    }

    @FXML
    void btnCancelClicked(MouseEvent event) {
        ViewInteractor.openScene("character.fxml");
    }

    @FXML
    void btnSortClicked(MouseEvent event) {
        if (attributeChoiceBox.getValue() != null) {
            sortCharacter(attributeChoiceBox.getValue());
            ViewInteractor.openScene("character.fxml");
            AlertContainer.showInformationAlert("Switch to Sort View.");
        } else {
            AlertContainer.showWarningAlert("Attribute choice box cannot be empty.");
        }
    }

    private void sortCharacter(String attribute) {
        LinkedList<Character> characters = new Sql().getAllCharacter();
        CharacterController.characters = characters;
        switch (attribute) {
            case "Height":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getHeight() < characters.get(j).getHeight()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Weight":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getWeight() < characters.get(j).getWeight()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Strength":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getStrength() < characters.get(j).getStrength()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Agility":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getAgility() < characters.get(j).getAgility()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Intelligence":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getIntelligence() < characters.get(j).getIntelligence()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Coordination":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getCoordination() < characters.get(j).getCoordination()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            case "Leadership":
                for (int i = 0; i < characters.size(); i++) {
                    for (int j = 1; j < characters.size()-i; j++) {
                        if (characters.get(j-1).getLeadership() < characters.get(j).getLeadership()) {
                            Character character = characters.remove(j);
                            characters.add(j-1, character);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
}
