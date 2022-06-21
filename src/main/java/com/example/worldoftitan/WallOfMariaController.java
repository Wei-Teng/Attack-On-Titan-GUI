package com.example.worldoftitan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WallOfMariaController implements Initializable {

    @FXML
    private Label edgesLabel;

    @FXML
    private Label labelWeakestPart;

    @FXML
    private TextField textFieldEdges;

    @FXML
    private TextField textFieldWeakestPart;

    @FXML
    private Button nextButton;

    @FXML
    private TextField textFieldLayers;

    @FXML
    private Button weakestPartButton;

    @FXML
    private ImageView imageWallofMaria;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("C:\\Users\\user\\Documents\\IntellijProjects\\WIA 1002 Data Structure\\Attack-On-Titan-GUI\\src\\Images\\tumblr_d1dd0be33d03e1f698d686c3ef7458eb_de90693b_540.jpg");
        imageWallofMaria.setImage(new Image(file.toURI().toString()));
    }

    @FXML
    void backToMain(ActionEvent event) {
        ViewInteractor.openScene("start.fxml");
    }

    @FXML
    void getLayersButton(ActionEvent event) {
        int noOfLayers = Integer.parseInt(textFieldLayers.getText());
        if (noOfLayers > 0) {
            textFieldEdges.setVisible(true);
            edgesLabel.setVisible(true);
            nextButton.setVisible(true);
        } else {
            textFieldLayers.setText("Please enter a valid number");
        }

        nextButton.setVisible(true);
    }

    int[] flag = new int[13];
    int i = 0;
    int count = 0;
    @FXML
    void nextButton(ActionEvent event) {

        count++;
        int noOfLayers = Integer.parseInt(textFieldLayers.getText());
        List<List<Integer>> layers = new ArrayList<>();
        for (int i = 0; i < noOfLayers; i++) layers.add(new ArrayList<>());
        if (i < noOfLayers-1) {
            String[] temp;
            int[] edges;
            edgesLabel.setText("Enter brick edges of layer " + (i+2) + ":");
            temp = textFieldEdges.getText().split(" ");
            textFieldEdges.setText("");

            edges = new int[temp.length];

            for (int j = 0; j < temp.length; j++) {
                edges[j] = Integer.parseInt(temp[j]);
                flag[edges[j]]++;
            }
            for (int e : edges) layers.get(i).add(e);
            i++;
        }

        System.out.println(i);

        if(count == noOfLayers){
            weakestPartButton.setVisible(true);
        }
    }

    @FXML
    void printWeakestPartButton(ActionEvent event) {
        int max = 0;
        int maxIndex = 0;
        for (int j = 0; j < flag.length; j++) {
            if (flag[j] > max) {
                max = flag[j];
                maxIndex = j;
            }
        }

        String weakestPart = String.valueOf(maxIndex);
        labelWeakestPart.setVisible(true);
        textFieldWeakestPart.setVisible(true);
        textFieldWeakestPart.setText(weakestPart);


        System.out.println(maxIndex);
    }
}



