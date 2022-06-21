package com.example.worldoftitan;

import com.example.worldoftitan.sql.Sql;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AddCharacterController implements Initializable {

    @FXML
    private TextField agilityTextField;
    @FXML
    private ImageView characterImageView;
    @FXML
    private TextField coordinationTextField;
    @FXML
    private ImageView designImageView1;
    @FXML
    private ImageView designImageView2;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField intelligenceTextField;
    @FXML
    private TextField leadershipTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField strengthTextField;
    @FXML
    private TextField weightTextField;

    private String selectedImagePath;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File defaultCharacterPicture = new File("src\\main\\resources\\com\\example\\worldoftitan\\Images\\no_photo.png");
        characterImageView.setImage(new Image(defaultCharacterPicture.toURI().toString()));

        File picture1 = new File("src\\Images\\aot_trio_cute.jpg");
        designImageView1.setImage(new Image(picture1.toURI().toString()));

        File picture2 = new File("src\\Images\\levi_cleaner.jpg");
        designImageView2.setImage(new Image(picture2.toURI().toString()));
    }

    @FXML
    void btnCancelClicked(MouseEvent event) {
        ViewInteractor.openScene("character.fxml");
    }

    @FXML
    void btnSaveClicked(MouseEvent event) {
        if (isValidInput()) {
            Character character = setUpCharacter();
            Sql sql = new Sql();
            sql.saveCharacter(character);
            AlertContainer.showInformationAlert("Character saved!!!");
            CharacterController.characters = new Sql().getAllCharacter();
            ViewInteractor.openScene("character.fxml");
        }
    }

    private boolean isValidInput() {
        try {
            LinkedList<Character> characters = new Sql().getAllCharacter();
            for (Character c : characters) {
                if (c.getName().equals(nameTextField.getText().trim()))
                    throw new Exception();
            }
            Integer.parseInt(heightTextField.getText().trim());
            Integer.parseInt(weightTextField.getText().trim());
            int strength = Integer.parseInt(strengthTextField.getText().trim());
            int agility = Integer.parseInt(agilityTextField.getText().trim());
            int intelligence = Integer.parseInt(intelligenceTextField.getText().trim());
            int coordination = Integer.parseInt(coordinationTextField.getText().trim());
            int leadership = Integer.parseInt(leadershipTextField.getText().trim());
            if (selectedImagePath == null || strength <= 0 || strength > 15 || agility <= 0 || agility > 15 ||
                    intelligence <= 0 || intelligence > 15 || coordination <= 0 || coordination > 15 ||
                    leadership <= 0 || leadership > 15)
                throw new Exception();
            return true;
        } catch (Exception e) {
            AlertContainer.showWarningAlert("Input is incorrect.\nNoted :\n" +
                    "i) All attributes except height and weight must between 1 and 15.\n" +
                    "ii) Character name must be unique.");
        }
        return false;
    }

    private Character setUpCharacter() {
        Character character = new Character(nameTextField.getText().trim(), Integer.parseInt(heightTextField.getText().trim()),
                Integer.parseInt(weightTextField.getText().trim()), Integer.parseInt(strengthTextField.getText().trim()),
                Integer.parseInt(agilityTextField.getText().trim()), Integer.parseInt(intelligenceTextField.getText().trim()),
                Integer.parseInt(coordinationTextField.getText().trim()), Integer.parseInt(leadershipTextField.getText().trim()),
                selectedImagePath);
        return character;
    }

    @FXML
    void characterImageViewClicked(MouseEvent event) {
        FileChooser fileChooser = setUpFileChooser();
        File selectedPicture = fileChooser.showOpenDialog(ViewInteractor.stage);
        if (selectedPicture == null)
            AlertContainer.showWarningAlert("You haven't select any image.");
        else
            updateImageView(selectedPicture);
    }

    private FileChooser setUpFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Insert character image");

        File userHomeDirectory = new File(System.getProperty("user.home"));
        if (!userHomeDirectory.canRead())
            userHomeDirectory= new File("C:\\");

        fileChooser.setInitialDirectory(userHomeDirectory);
        return fileChooser;
    }

    private void updateImageView(File picturePath) {
        try {
            selectedImagePath = picturePath.toString().replace("\\", "/");
            BufferedImage bufferedImage = ImageIO.read(picturePath);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            characterImageView.setImage(image);
        } catch (IOException e) {
            AlertContainer.showWarningAlert("It is not a valid image.");
        }
    }
}
