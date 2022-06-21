package com.example.worldoftitan;

import com.example.worldoftitan.sql.Sql;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javax.print.attribute.standard.Media;

import java.io.File;
import java.net.URL;
import java.util.*;

public class playController implements Initializable {

    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane anchorPane2;
    @FXML
    BorderPane borderPane;
    @FXML
    AnchorPane finalPane;
    @FXML
    Button finalOkButton;
    @FXML
    TextArea finalText;
    @FXML
    VBox vBox;
    @FXML
    ScrollPane scrollPane;
    @FXML
    Button backButton;
    @FXML
    VBox popUp;
    @FXML
    TextField titanNum;
    @FXML
    ImageView mapView;
    @FXML
    ImageView pathView;
    @FXML
    Button buttonZero;
    @FXML
    Button buttonOne;
    @FXML
    Button buttonTwo;
    @FXML
    Button buttonThree;
    @FXML
    Button buttonFour;
    @FXML
    Button buttonFive;
    @FXML
    Button buttonSix;
    @FXML
    Button buttonSeven;
    @FXML
    Button buttonEight;
    @FXML
    Button buttonNine;
    @FXML
    Button buttonTen;
    @FXML
    Button buttonEleven;
    @FXML
    Button buttonTwelve;
    @FXML
    Button buttonThirteen;
    @FXML
    Button buttonFourteen;
    @FXML
    TextArea titanDisplay;
    @FXML
    TextArea sequenceDisplay;
    @FXML
    Label distanceDisplay;
    @FXML
    Button buttonFifteen;
    @FXML
    ImageView soldierImage;
    Character charButton;
    static int numOfVertices;
    static AotGraph aotGraph;
    int numOfTitanAlive;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        finalPane.setVisible(false);
        popUp.setVisible(false);
        anchorPane2.setVisible(false);
        anchorPane.setVisible(true);

        scrollPane.setStyle(
                "-fx-background-color: #FFECCF;"+
                "-fx-background-size: cover;"
        );

        vBox.setStyle(
                "-fx-background-color: #FFECCF;"+
                "-fx-background-size: cover;"
        );

        LinkedList<Character> charList = new Sql().getAllCharacter();

        for(Character c : charList){
            HBox container = new HBox();
            container.setPadding(new Insets(20, 5, 20, 5));
            container.setSpacing(60);
            container.setAlignment(Pos.CENTER);

            HBox frame = new HBox();
            Button plusButton = new Button("+");
            c.setCharButton(plusButton);

            frame.setSpacing(30);
            frame.setAlignment(Pos.CENTER);
            frame.setMinWidth(900);
            frame.setMinHeight(200);
            frame.setStyle(
                    "-fx-background-color: #D2C4AE;"+
                    "-fx-background-size: cover;"+
                    "-fx-background-radius: 20px;"+
                    "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0, 2, 2);"
            );

            plusButton.setOnAction(e -> {
                charButton = c;
                GaussianBlur gb = new GaussianBlur(20);
                anchorPane.setMouseTransparent(true);
                anchorPane.setEffect(gb);
                popUp.setVisible(true);
            });

            plusButton.setStyle(
                    "-fx-background-radius: 50px; " +
                    "-fx-min-width: 70px; " +
                    "-fx-min-height: 70px; " +
                    "-fx-pref-width: 70px; " +
                    "-fx-pref-height: 70px;"+
                    "-fx-background-color: #457439;"+
                    "-fx-text-fill: #FFECCF;"+
                    "-fx-font-size: 35px;"+
                    "-fx-padding: 10px;"
            );
            plusButton.setAlignment(Pos.CENTER);

            File file = new File(c.getImagePath());
            ImageView imageView = new ImageView();
            imageView.setImage(new Image(file.toURI().toString()));
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(150);
            imageView.setFitWidth(150);

            Label charInfo1 = new Label();
            charInfo1.setText(c.toString());
            charInfo1.setStyle(
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #403535;"
            );
            Label charInfo2 = new Label();
            charInfo2.setText(c.toString2());
            charInfo2.setStyle(
                    "-fx-background-color: transparent;"+
                    "-fx-text-fill: #403535;"
            );

            frame.getChildren().addAll(imageView, charInfo1, charInfo2);
            container.getChildren().addAll(frame, plusButton);
            vBox.getChildren().add(container);
            scrollPane.setContent(vBox);
            borderPane.setCenter(scrollPane);
        }
    }

    public void backButton(){
        ViewInteractor.openScene("start.fxml");
    }

    public void backButton2(){
        anchorPane.setVisible(true);
        anchorPane2.setVisible(false);

        //reset the display of the buttons
        String buttonStyle = "-fx-background-color: #457439";
        for(int i = 0; i < 16; i++) recolourButton(i,buttonStyle);

        sequenceDisplay.setText("");
    }

    public void cancelButton(){
        anchorPane.setMouseTransparent(false);
        anchorPane.setEffect(null);
        popUp.setVisible(false);
    }

    public void startButton(){
        try {
            Integer.parseInt(titanNum.getText());
        } catch (NumberFormatException nfe) {return;}

        anchorPane.setVisible(false);
        anchorPane.setMouseTransparent(false);
        anchorPane.setEffect(null);
        popUp.setVisible(false);
        anchorPane2.setVisible(true);
        Rectangle clip = new Rectangle(mapView.getFitHeight(), mapView.getFitWidth());
        clip.setArcHeight(50);
        clip.setArcWidth(50);
        mapView.setClip(clip);

        mapView.setImage(new Image("file:src/main/resources/com/example/worldoftitan/Images/map.jpg"));
        pathView.setImage(new Image("file:src/main/resources/com/example/worldoftitan/Images/straightPaths.png"));
        soldierImage.setImage(new Image("file:src/main/resources/com/example/worldoftitan/Images/ErenYeager.png"));

        //initialize the graph
        graphInitializer();

        //Titan Queues
        PriorityQueue<Titan> titanPriorityQueue = new PriorityQueue<>();
        Queue<Titan> titanQueue = new LinkedList<>();
        Queue<Integer> sequence = new LinkedList<>();

        int initialNumOfTitans = Integer.parseInt(titanNum.getText());
        int numOfTitans = initialNumOfTitans;
        generateXNumberOfTitans(initialNumOfTitans,titanPriorityQueue,titanQueue);

        //Titan info
        StringBuilder titanOutput = new StringBuilder();
        displayTitanInfo(titanQueue, titanOutput);

        //newTitan queue (store the node of new titans - when they appear)
        Queue<Titan> newTitanButton = new LinkedList<>();
        //List for checking if soldier should run
//        ArrayList<Titan> checkRiskList = new ArrayList<>();

        Queue<String> newTitanSequence = new LinkedList<>();

        //first position
        sequence.add(0);

        for(int i = 0; i < initialNumOfTitans; i++){
            StringBuilder sequenceOutput = new StringBuilder();
            sequenceOutput.append(sequenceDisplay.getText());
            if(i==0) {
                sequenceOutput.append("Sequence to be killed:\n");
                sequenceDisplay.setText(sequenceOutput.toString());
                printSequence(titanPriorityQueue,sequence,true);
            }
            else if((i+1)%3==0){ //every third initial titans will spawn a new titan
                if(!titanPriorityQueue.isEmpty()) sequence.offer(titanPriorityQueue.poll().getPosition());
                //generate new titan in the middle of the fight
                sequenceOutput.append("\nNew sequence:\n");
                Titan newTitan = generateTitan(++numOfTitans);
                if(newTitan.getRisk()<=charButton.getStrength()+charButton.getAgility()){
                    titanPriorityQueue.add(newTitan);
                    sequenceDisplay.setText(sequenceOutput.toString());
                    printSequence(titanPriorityQueue,sequence,true);
                }
                else numOfTitanAlive++;
                newTitanButton.add(newTitan);
            }
        }
        sequence = printSequence(titanPriorityQueue,sequence,false);

        //titan arraylist (store the node and timing of all the titans including new titans - when killing titan)
        Queue<Integer> displayTime = new LinkedList<>();
        Queue<Integer> displayButton = new LinkedList<>();

        // Path transition Animation
        // Starting point
        int initX = 50;
        int initY = 50;
        MoveTo init = new MoveTo(initX, initY);
        Path path = new Path();
        path.getElements().add(init);
        int totalDistance = move(sequence, displayTime, displayButton, initX, initY, path);
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(totalDistance));
        transition.setNode(soldierImage);
        transition.setPath(path);
        transition.setInterpolator(Interpolator.LINEAR);
        PauseTransition pause1 = new PauseTransition(Duration.millis(1000));
        SequentialTransition sequentialTransition = new SequentialTransition(pause1,transition);
        //End of Path transition

        //Display the text on the screen
        titanDisplay.setText(titanNum.getText() + " Titans Appeared!\n" + titanOutput);
        distanceDisplay.setText("Total Distance: " + totalDistance);
        titanNum.setText(null);

        Thread.UncaughtExceptionHandler handler = (th, ex) -> System.out.println("Uncaught exception: " + ex);
        Thread thread1 = new Thread(sequentialTransition::play);
        Thread thread2 = new Thread(() -> animationCountdown(totalDistance, displayTime, displayButton));
        Thread thread3 = new Thread(() -> {
           for(int i = 0; i < totalDistance; i++){
               if((i+1)%3==0 && !newTitanButton.isEmpty()) {
                   Titan titan = newTitanButton.poll();
                   displayTitan(titan);

                   //Update new titan info on the display
                   titanDisplay.setText(titanDisplay.getText() + "Titan " + titan.getIndex() + ": " + titan + " | position: " + titan.getPosition() + "\n\n");
               }
               try {Thread.sleep(1000);}catch (InterruptedException e) {throw new RuntimeException(e);}
           }
        });
        thread1.setUncaughtExceptionHandler(handler);
        thread1.start();
        thread2.setUncaughtExceptionHandler(handler);
        thread2.start();
        thread3.setUncaughtExceptionHandler(handler);
        thread3.start();
    }

    private void graphInitializer(){
        numOfVertices = 16;
        aotGraph = new AotGraph(numOfVertices);
        aotGraph.addEdge(0,1);
        aotGraph.addEdge(0,5);
        aotGraph.addEdge(0,7);
        aotGraph.addEdge(1,2);
        aotGraph.addEdge(1,4);
        aotGraph.addEdge(1,6);
        aotGraph.addEdge(2,3);
        aotGraph.addEdge(2,11);
        aotGraph.addEdge(2,13);
        aotGraph.addEdge(3,10);
        aotGraph.addEdge(4,6);
        aotGraph.addEdge(4,10);
        aotGraph.addEdge(5,6);
        aotGraph.addEdge(5,7);
        aotGraph.addEdge(5,12);
        aotGraph.addEdge(6,8);
        aotGraph.addEdge(6,15);
        aotGraph.addEdge(7,9);
        aotGraph.addEdge(8,10);
        aotGraph.addEdge(9,12);
        aotGraph.addEdge(9,15);
        aotGraph.addEdge(10,14);
        aotGraph.addEdge(11,13);
        aotGraph.addEdge(13,14);
        aotGraph.addEdge(14,15);
        for(int i = 0; i < 16; i++) aotGraph.setOccupation(i,false);
    }
//ArrayList<Titan> checkRiskList,
    private Queue<Integer> printSequence(PriorityQueue<Titan> titanPriorityQueue, Queue<Integer> sequence,boolean print){
        PriorityQueue<Titan> pq = new PriorityQueue<>(titanPriorityQueue);
        Queue<Integer> seq = new LinkedList<>(sequence);

        StringBuilder sequenceOutput = new StringBuilder();
        sequenceOutput.append(sequenceDisplay.getText());
//        boolean flag = false;
//        int count = 0;
        while (!pq.isEmpty()) {
            Titan titan = pq.poll();
//            if(print && !flag){
//                checkRiskList.add(titan);
//                flag = true;
//            }else if (!print && count>0) {
//                checkRiskList.add(titan);
//            }
            assert titan != null : "Titan is null";
            if (pq.isEmpty()) {
                sequenceOutput.append("Titan ").append(titan.getIndex());
            } else sequenceOutput.append("Titan ").append(titan.getIndex()).append(" --> ");
            if(print) sequenceDisplay.setText(sequenceOutput.toString());
            seq.offer(titan.getPosition());
//            count++;
        }
        return seq;
    }

    private Titan generateTitan(int index){
        Random rand = new Random();
        int position;
        do {
            position = rand.nextInt(numOfVertices);
        }while (aotGraph.getOccupation(position));
        aotGraph.setOccupation(position,true);
        String typeStr;
        int type = rand.nextInt(7);
        if(type<4) typeStr = "Normal";
        else if(type<6) typeStr = "Abnormal";
        else {
            int species = rand.nextInt(9);
            switch (species) {
                case 0 -> typeStr = "Founding";
                case 1 -> typeStr = "Attack";
                case 2 -> typeStr = "War Hammer";
                case 3 -> typeStr = "Cart";
                case 4 -> typeStr = "Jaw";
                case 5 -> typeStr = "Armored";
                case 6 -> typeStr = "Beast";
                case 7 -> typeStr = "Female";
                default -> typeStr = "Colossal";
            }
        }
        return new Titan(typeStr,index,position);
    }

    private void generateXNumberOfTitans(int numOfTitans, PriorityQueue<Titan> titanPriorityQueue, Queue<Titan> titanQueue){
        numOfTitanAlive = 0;
        for(int i = 0; i < numOfTitans; i++){
            Titan titan = generateTitan(i+1);
            if(titan.getRisk()<=charButton.getAgility()+charButton.getStrength()) titanPriorityQueue.add(titan);
            else numOfTitanAlive++;
            titanQueue.add(titan);
            //display titans' initial position on the buttons/coordinate
            displayTitan(titan);
        }
    }

    private void displayTitan(Titan titan){
        int position = titan.getPosition();
        String buttonStyle;
        if(titan.getType().equals("Normal")) buttonStyle = "-fx-background-image: url('file:src/main/resources/com/example/worldoftitan/Images/normal.jpg');-fx-background-size: cover;";
        else if(titan.getType().equals("Abnormal")) buttonStyle = "-fx-background-image: url('file:src/main/resources/com/example/worldoftitan/Images/abnormal.png');-fx-background-size: cover;";
        else buttonStyle = "-fx-background-image: url('file:src/main/resources/com/example/worldoftitan/Images/NineTitans.png');-fx-background-size: cover;";
        recolourButton(position,buttonStyle);
    }

    private void displayTitanInfo(Queue<Titan> titanQueue, StringBuilder titanOutput){
        while(!titanQueue.isEmpty()){
            Titan titan = titanQueue.poll();
            assert titan != null : "Titan is null";
            titanOutput.append("Titan ").append(titan.getIndex()).append(": ").append(titan).append(" | position: ").append(titan.getPosition()).append("\n\n");
        }
    }

    private void recolourButton(int buttonNum, String buttonStyle){
        switch (buttonNum) {
            case 0 -> buttonZero.setStyle(buttonStyle);
            case 1 -> buttonOne.setStyle(buttonStyle);
            case 2 -> buttonTwo.setStyle(buttonStyle);
            case 3 -> buttonThree.setStyle(buttonStyle);
            case 4 -> buttonFour.setStyle(buttonStyle);
            case 5 -> buttonFive.setStyle(buttonStyle);
            case 6 -> buttonSix.setStyle(buttonStyle);
            case 7 -> buttonSeven.setStyle(buttonStyle);
            case 8 -> buttonEight.setStyle(buttonStyle);
            case 9 -> buttonNine.setStyle(buttonStyle);
            case 10 -> buttonTen.setStyle(buttonStyle);
            case 11 -> buttonEleven.setStyle(buttonStyle);
            case 12 -> buttonTwelve.setStyle(buttonStyle);
            case 13 -> buttonThirteen.setStyle(buttonStyle);
            case 14 -> buttonFourteen.setStyle(buttonStyle);
            case 15 -> buttonFifteen.setStyle(buttonStyle);
        }
    }

    private int move(Queue<Integer> sequence, Queue<Integer> displayTime, Queue<Integer> displayButton, int initX, int initY, Path path){
        int totalDistance = 0;
        while(sequence.size()>1){
            int source = sequence.poll();
            int dest = 0;
            if(!sequence.isEmpty()) dest = sequence.peek();

            ArrayList<Integer> list = aotGraph.printShortestPath(source, dest);

            int size = list.size();
            displayTime.offer(size-1);
            displayButton.offer(list.get(size-1));

            for (int i = 0; i < size; i++) {
                if(i==0) continue;
                int node = list.get(i);
                int x = 0;
                int y = 0;
                switch (node) {
                    case 0 -> { x = (int) buttonZero.getLayoutX();
                        y = (int) buttonZero.getLayoutY();}
                    case 1 -> { x = (int) buttonOne.getLayoutX();
                        y = (int) buttonOne.getLayoutY();}
                    case 2 -> { x = (int) buttonTwo.getLayoutX();
                        y = (int) buttonTwo.getLayoutY();}
                    case 3 -> { x = (int) buttonThree.getLayoutX();
                        y = (int) buttonThree.getLayoutY();}
                    case 4 -> { x = (int) buttonFour.getLayoutX();
                        y = (int) buttonFour.getLayoutY();}
                    case 5 -> { x = (int) buttonFive.getLayoutX();
                        y = (int) buttonFive.getLayoutY();}
                    case 6 -> { x = (int) buttonSix.getLayoutX();
                        y = (int) buttonSix.getLayoutY();}
                    case 7 -> { x = (int) buttonSeven.getLayoutX();
                        y = (int) buttonSeven.getLayoutY();}
                    case 8 -> { x = (int) buttonEight.getLayoutX();
                        y = (int) buttonEight.getLayoutY();}
                    case 9 -> { x = (int) buttonNine.getLayoutX();
                        y = (int) buttonNine.getLayoutY();}
                    case 10 -> { x = (int) buttonTen.getLayoutX();
                        y = (int) buttonTen.getLayoutY();}
                    case 11 -> { x = (int) buttonEleven.getLayoutX();
                        y = (int) buttonEleven.getLayoutY();}
                    case 12 -> { x = (int) buttonTwelve.getLayoutX();
                        y = (int) buttonTwelve.getLayoutY();}
                    case 13 -> { x = (int) buttonThirteen.getLayoutX();
                        y = (int) buttonThirteen.getLayoutY();}
                    case 14 -> { x = (int) buttonFourteen.getLayoutX();
                        y = (int) buttonFourteen.getLayoutY();}
                    case 15 -> { x = (int) buttonFifteen.getLayoutX();
                        y = (int) buttonFifteen.getLayoutY();}
                }
                int zeroX = (int) soldierImage.getLayoutX();
                int zeroY = (int) soldierImage.getLayoutY();
                if(x < soldierImage.getLayoutX()) x = -(zeroX-x)+initX;
                else x = (x-zeroX)+initX;

                if(y < soldierImage.getLayoutY()) y = -(zeroY-y)+initY;
                else y = (y-zeroY)+initY;
                path.getElements().add(new LineTo(x,y));
            }
            totalDistance += list.size()-1;
        }
        return totalDistance;
    }
//, ArrayList<Titan> checkRiskList
    private void animationCountdown(int totalDistance, Queue<Integer> displayTime, Queue<Integer> displayButton){
//        String musicFile = "C:/Users/e-hen/Downloads/Y1S2/DS/sword1.mp3";
//        Media sound = new Media(new File(musicFile).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setVolume(0.1);
        int count = 0;
//        int index = 0;
        for(int i = 0; i <= totalDistance; i++){
            try {Thread.sleep(1000);}catch (InterruptedException e) {throw new RuntimeException(e);}

            if(!displayTime.isEmpty() && displayTime.peek()==count){
                displayTime.poll();
//                int risk = checkRiskList.get(index).getRisk();
//                int soldierPower = charButton.getAgility()+charButton.getStrength();
//                if(risk <= soldierPower){
                    //play killing audio
//                    mediaPlayer.seek(Duration.ZERO);
//                    mediaPlayer.play();

                    int buttonNum = 0;
                    if(!displayButton.isEmpty()) buttonNum = displayButton.poll();
                    String buttonStyle = "-fx-background-color: #457439";
                    recolourButton(buttonNum,buttonStyle);
//                }
                count = 0;
//                index++;
            }
            count++;
        }
        try {Thread.sleep(1000);}catch (InterruptedException e) {throw new RuntimeException(e);}
        finalText.setText("There are " + numOfTitanAlive + " titan(s) alive!");

        GaussianBlur gb = new GaussianBlur(20);
        anchorPane2.setMouseTransparent(true);
        anchorPane2.setEffect(gb);
        finalPane.setVisible(true);
    }

    public void okButton(){
        backButton2();
        finalPane.setVisible(false);
        anchorPane2.setMouseTransparent(false);
        anchorPane2.setEffect(null);
    }
}
