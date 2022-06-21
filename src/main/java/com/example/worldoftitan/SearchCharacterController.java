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
import java.util.*;

public class SearchCharacterController implements Initializable {

    @FXML
    private ChoiceBox<String> attributeChoiceBox;
    @FXML
    private ImageView designImageView1;
    @FXML
    private ImageView designImageView2;
    @FXML
    private ChoiceBox<Integer> valueChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File picture1 = new File("src\\Images\\aot_trio_cute.jpg");
        designImageView1.setImage(new Image(picture1.toURI().toString()));

        File picture2 = new File("src\\Images\\levi_cleaner.jpg");
        designImageView2.setImage(new Image(picture2.toURI().toString()));

        attributeChoiceBox.setItems(FXCollections.observableArrayList("Strength", "Agility",
                "Intelligence", "Coordination", "Leadership"));
        valueChoiceBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    }

    @FXML
    void btnCancelClicked(MouseEvent event) {
        ViewInteractor.openScene("character.fxml");
    }

    @FXML
    void btnSearchClicked(MouseEvent event) {
        if (attributeChoiceBox.getValue() != null && valueChoiceBox.getValue() != null) {
            CharacterController.characters =
                    linearSearch(groupUpCharacterBasedOnAttributeValue(attributeChoiceBox.getValue()),
                    valueChoiceBox.getValue());
            ViewInteractor.openScene("character.fxml");
            AlertContainer.showInformationAlert("Switch to Search View.");
        } else {
            AlertContainer.showWarningAlert("Attribute and Value choice box cannot be empty");
        }
    }

    private LinkedList<Character> linearSearch
    (HashMap<Integer, LinkedList<Character>> characterListByAttributeValue, int target) {
        for (int key : characterListByAttributeValue.keySet()) {
            if (key == target)
                return characterListByAttributeValue.get(key);
        }
        return new LinkedList<>();
    }

    private HashMap<Integer, LinkedList<Character>> groupUpCharacterBasedOnAttributeValue(String attribute) {
        HashMap<Integer, LinkedList<Character>> characterListByAttributeValue = new HashMap<>();
        LinkedList<Character> characters = new Sql().getAllCharacter();
        switch (attribute) {
            case "Height":
                for (Character character : characters)
                    groupUp(character, character.getHeight(), characterListByAttributeValue);
                break;
            case "Weight":
                for (Character character : characters)
                    groupUp(character, character.getWeight(), characterListByAttributeValue);
                break;
            case "Strength":
                for (Character character : characters)
                    groupUp(character, character.getStrength(), characterListByAttributeValue);
                break;
            case "Agility":
                for (Character character : characters)
                    groupUp(character, character.getAgility(), characterListByAttributeValue);
                break;
            case "Intelligence":
                for (Character character : characters)
                    groupUp(character, character.getIntelligence(), characterListByAttributeValue);
                break;
            case "Coordination":
                for (Character character : characters)
                    groupUp(character, character.getCoordination(), characterListByAttributeValue);
                break;
            case "Leadership":
                for (Character character : characters)
                    groupUp(character, character.getLeadership(), characterListByAttributeValue);
                break;
            default:
                break;
        }
        return characterListByAttributeValue;
    }

    private void groupUp(Character character, int key,
                         HashMap<Integer, LinkedList<Character>> characterListByAttributeValue) {
        LinkedList<Character> temp;
        if (characterListByAttributeValue.containsKey(key))
            temp = characterListByAttributeValue.get(key);
        else
            temp = new LinkedList<>();
        temp.add(character);
        characterListByAttributeValue.put(key, temp);
    }
}
