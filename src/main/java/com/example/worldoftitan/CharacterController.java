package com.example.worldoftitan;

import com.example.worldoftitan.sql.Sql;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class CharacterController implements Initializable {

    public static LinkedList<Character> characters = new Sql().getAllCharacter();

    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCharacterListView(characters);
    }

    @FXML
    void btnAddClicked(MouseEvent event) {
        ViewInteractor.openScene("add_character.fxml");
    }
    @FXML
    void btnBackClicked(MouseEvent event) {
        ViewInteractor.openScene("start.fxml");
    }
    @FXML
    void btnListClicked(MouseEvent event) {
        characters = new Sql().getAllCharacter();
        ViewInteractor.openScene("character.fxml");
        AlertContainer.showInformationAlert("Switch to List View.");
    }
    @FXML
    void btnSearchClicked(MouseEvent event) {
        ViewInteractor.openScene("search_character.fxml");
    }

    @FXML
    void btnSortClicked(MouseEvent event) {
        ViewInteractor.openScene("sort_character.fxml");
    }

    public void createCharacterListView(LinkedList<Character> characters) {
        for (Character character : characters) {
            AnchorPane anchorPane = setUpAnchorPane();
            ImageView characterImageView = setUpImageView(character);
            Button removeButton = setUpRemoveButton(character);

            Label nameLabel = setUpNameLabel(character.getName(), 320, 5);
            Label heightLabel = setUpAttributeLabel("Height: " + character.getHeight() + "cm", 320, 50);
            Label weightLabel = setUpAttributeLabel("Weight: " + character.getWeight() + "kg", 320, 90);
            Label strengthLabel = setUpAttributeLabel("Strength: " + character.getStrength(), 320, 130);
            Label agilityLabel = setUpAttributeLabel("Agility: " + character.getAgility(), 800, 30);
            Label intelligenceLabel = setUpAttributeLabel("Intelligence: " + character.getIntelligence(), 800, 70);
            Label coordinationLabel = setUpAttributeLabel("Coordination: " + character.getCoordination(), 800, 110);
            Label leadershipLabel = setUpAttributeLabel("Leadership: " + character.getLeadership(), 800, 150);
            // Empty Label is very important in order to fill up empty space and have correct display !!!!!
            Label emptyLabel = setUpAttributeLabel("", 20, 180);

            anchorPane.getChildren().addAll(characterImageView, nameLabel, heightLabel, weightLabel, strengthLabel,
                    agilityLabel, intelligenceLabel, coordinationLabel, leadershipLabel, removeButton, emptyLabel);
            vbox.getChildren().add(anchorPane);

        }
    }

    private AnchorPane setUpAnchorPane() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(1320, 200);
        anchorPane.setStyle("-fx-background-color: #D2C4AE;" +
                "-fx-background-radius: 20px;");
        return anchorPane;
    }

    private ImageView setUpImageView(Character character) {
        ImageView characterImageView = new ImageView();
        File file = new File(character.getImagePath());
        characterImageView.setImage(new Image(file.toURI().toString()));
        characterImageView.setPreserveRatio(false);
        characterImageView.setFitHeight(150);
        characterImageView.setFitWidth(150);
        characterImageView.setLayoutX(30);
        characterImageView.setLayoutY(25);
        return characterImageView;
    }

    private Button setUpRemoveButton(Character character) {
        Button removeButton = new Button("Del");
        removeButton.setOnAction(e -> {
            new Sql().removeCharacter(character.getName());
            characters.remove(character);
            ViewInteractor.openScene("character.fxml");
        });
        removeButton.setCursor(Cursor.HAND);
        removeButton.setPrefSize(100, 100);
        removeButton.setStyle("-fx-background-radius: 50px;");
        removeButton.setLayoutX(1100);
        removeButton.setLayoutY(48.5);
        return removeButton;
    }

    private Label setUpNameLabel(String contentText, int layoutX, int layoutY) {
        Label label = new Label(contentText);
        label.setFont(Font.font("arial", FontWeight.BOLD, 24));
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        return label;
    }

    private Label setUpAttributeLabel(String contentText, int layoutX, int layoutY) {
        Label label = new Label(contentText);
        label.setFont(new Font("arial", 18));
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        return label;
    }
}
