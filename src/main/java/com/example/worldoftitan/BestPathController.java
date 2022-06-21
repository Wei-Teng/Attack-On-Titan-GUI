package com.example.worldoftitan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.*;


public class BestPathController{
    static protected String resultPath;
    private int source;
    private int end;
    private int count;

    @FXML
    private Label DisplayBox;

    @FXML
    private ImageView AoTMap;

    @FXML
    void btnBackClicked(ActionEvent event) {
        ViewInteractor.openScene("start.fxml");
    }

    @FXML
    void btnResetClick(ActionEvent event){
        source = -1;
        end = -1;
        count = 0;
        resultPath = "";
        resetButtonColor();
        DisplayBox.setText("Showing Path ...");
    }


    @FXML
    private Button btn0;
    @FXML
    void btnStartingVertices0(ActionEvent event){
        if(count == 0){
            source = 0;
        } else if (count == 1){
            end = 0;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn0.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn1;
    @FXML
    void btnStartingVertices1(ActionEvent event){
        if(count == 0){
            source = 1;
        } else if (count == 1){
            end = 1;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn1.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn2;
    @FXML
    void btnStartingVertices2(ActionEvent event){
        if(count == 0){
            source = 2;
        } else if (count == 1){
            end = 2;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn2.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn3;
    @FXML
    void btnStartingVertices3(ActionEvent event){
        if(count == 0){
            source = 3;
        } else if (count == 1){
            end = 3;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn3.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn4;
    @FXML
    void btnStartingVertices4(ActionEvent event){
        if(count == 0){
            source = 4;
        } else if (count == 1){
            end = 4;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn4.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn5;
    @FXML
    void btnStartingVertices5(ActionEvent event){
        if(count == 0){
            source = 5;
        } else if (count == 1){
            end = 5;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn5.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn6;
    @FXML
    void btnStartingVertices6(ActionEvent event){
        if(count == 0){
            source = 6;
        } else if (count == 1){
            end = 6;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn6.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn7;
    @FXML
    void btnStartingVertices7(ActionEvent event){
        if(count == 0){
            source = 7;
        } else if (count == 1){
            end = 7;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn7.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn8;
    @FXML
    void btnStartingVertices8(ActionEvent event){
        if(count == 0){
            source = 8;
        }else if (count == 1){
            end = 8;
        }else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn8.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn9;
    @FXML
    void btnStartingVertices9(ActionEvent event){
        if(count == 0){
            source = 9;
        } else if (count == 1){
            end = 9;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn9.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn10;
    @FXML
    void btnStartingVertices10(ActionEvent event){
        if(count == 0){
            source = 10;
        } else if (count == 1){
            end = 10;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }

        btn10.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn11;
    @FXML
    void btnStartingVertices11(ActionEvent event){
        if(count == 0){
            source = 11;
        } else if (count == 1){
            end = 11;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn11.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn12;
    @FXML
    void btnStartingVertices12(ActionEvent event){
        if(count == 0){
            source = 12;
        } else if (count == 1){
            end = 12;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn12.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn13;
    @FXML
    void btnStartingVertices13(ActionEvent event){
        if(count == 0){
            source = 13;
        } else if (count == 1){
            end = 13;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn13.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn14;
    @FXML
    void btnStartingVertices14(ActionEvent event){
        if(count == 0){
            source = 14;
        } else if (count == 1){
            end = 14;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn14.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    private Button btn15;
    @FXML
    void btnStartingVertices15(ActionEvent event){
        if(count == 0){
            source = 15;
        } else if (count == 1){
            end = 15;
        } else {
            DisplayBox.setText("The button is selected too much. Please reset!");
        }
        btn15.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
        count++;
    }

    @FXML
    void RunBtn(ActionEvent event){
        findBestPath(source,end);
        DisplayBox.setText(resultPath);
    }

    void resetButtonColor(){
        btn0.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn1.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn2.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn3.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn4.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn5.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn6.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn7.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn8.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn9.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn10.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn11.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn12.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn13.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn14.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
        btn15.setStyle("-fx-background-color: #FFECCF; -fx-text-fill: #403535;");
    }

    void findBestPath(int source, int end) {
        UnweightedGraph graph = new UnweightedGraph(16);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(0,7);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(1,6);
        graph.addEdge(2,3);
        graph.addEdge(2,11);
        graph.addEdge(2,13);
        graph.addEdge(3,10);
        graph.addEdge(4,6);
        graph.addEdge(4,10);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(5,12);
        graph.addEdge(6,8);
        graph.addEdge(6,15);
        graph.addEdge(7,9);
        graph.addEdge(8,10);
        graph.addEdge(9,12);
        graph.addEdge(9,15);
        graph.addEdge(10,14);
        graph.addEdge(11,13);
        graph.addEdge(13,14);
        graph.addEdge(14,15);

        resultPath = graph.printShortestPaths(source,end);
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Rectangle rectangle = new Rectangle(0, 0, 960, 635);
//        rectangle.setArcWidth(20.0);   // Corner radius
//        rectangle.setArcHeight(20.0);
//
//        ImagePattern pattern = new ImagePattern(
//                new Image("AoTMap.png", 960, 635, false, false) // Resizing
//        );
//
//        rectangle.setFill(pattern);
//    }
}

class UnweightedGraph {
    private final int vertices;
    private final ArrayList<ArrayList<Integer>> adj;

    UnweightedGraph(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    String printShortestPaths(int source, int dest) {
        String resultPath = "";
        int algoCount = 0;
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        for (int i = 0; i < vertices; i++) parent.add(new ArrayList<>());

        BFS(parent, source);
        searchPaths(paths, path, parent, dest);

        for (ArrayList<Integer> x : paths) {
            Collections.reverse(x);
            if(algoCount < 1){
                for (int i = 0; i < x.size(); i++) {
                    if (i == x.size() - 1) resultPath += String.valueOf(x.get(i));
                    else resultPath += String.valueOf(x.get(i)) + " -> ";
                }
            }
            algoCount++;
        }
        return resultPath;
    }

    private void BFS(ArrayList<ArrayList<Integer>> parent, int source) {
        int[] dist = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        queue.offer(source);

        parent.get(source).clear();
        parent.get(source).add(-1);

        dist[source] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i : adj.get(x)) {

                if (dist[i] > dist[x] + 1) {
                    dist[i] = dist[x] + 1;
                    queue.offer(i);
                    parent.get(i).clear();
                    parent.get(i).add(x);
                } else if (dist[i] == dist[x] + 1) {
                    parent.get(i).add(x);
                }
            }
        }
    }

    private void searchPaths(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> parent, int dest) {
        if (dest == -1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int d : parent.get(dest)) {
            path.add(dest);

            searchPaths(paths, path, parent, d);

            path.remove(path.size() - 1);
        }
    }
}
