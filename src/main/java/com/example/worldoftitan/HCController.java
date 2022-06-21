package com.example.worldoftitan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HCController {
    @FXML
    private Label DisplayBox;


    private String resultCycle;
    private int selectedNode;

    int z = 0;

    void hamiltonianCycle(int SelectedVertices){
        // consider a complete graph having 16 vertices
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 5), new Edge(0, 7),
                new Edge(1, 4), new Edge(1, 6), new Edge(1,2),
                new Edge(2, 3), new Edge(2, 11), new Edge(2, 13),
                new Edge(3, 10),
                new Edge(4, 10), new Edge(4, 6),
                new Edge(5, 7), new Edge(5, 12), new Edge(5, 6),
                new Edge(6, 8), new Edge(6, 15),
                new Edge(7, 9),
                new Edge(8, 10),
                new Edge(9, 12), new Edge(9, 15),
                new Edge(10, 14),
                new Edge(11, 13),
                new Edge(13, 14),
                new Edge(14, 15)
        );

        // total number of nodes in the graph (labelled from 0 to 15)
        int n = 16;

        //Initialize z to 0
        z = 0;

        //Initialize resultCycle as null
        resultCycle = "";

        //Select a starting vertices
        selectedNode = SelectedVertices;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        findHamiltonianPaths(graph, n);
    }

    void findHamiltonianPaths(Graph graph, int n)
    {
        // start with every node
        for (int start = 0; start < n; start++)
        {
            // add starting node to the path
            List<Integer> path = new ArrayList<>();
            path.add(start);

            // mark the start node as visited
            boolean[] visited = new boolean[n];
            visited[start] = true;

            hamiltonianPaths(graph, start, visited, path, n, selectedNode);
        }
    }

    List<List<Integer>> allPath;
    void hamiltonianPaths(Graph graph, int v, boolean[] visited,
                          List<Integer> path, int n, int selectedNode)
    {

        allPath = new ArrayList<>();

        //Hashmap to store the adjacent vertices
        HashMap<Integer, Integer[]> adjacentVertices = new HashMap<>();
        Integer [][] vertices = {{1,5,7},{0,4,6},{1,3,11,13},{2,10},{1,6,10},
                {0,6,7,12},{1,4,5,8,15},{0,5,9},{6,10},{7,12,15},
                {3,4,8,14},{2,13},{5,9},{2,11,14},{10,13,15},{6,9,14}};
        adjacentVertices.put(0,vertices[0]);
        adjacentVertices.put(1,vertices[1]);
        adjacentVertices.put(2,vertices[2]);
        adjacentVertices.put(3,vertices[3]);
        adjacentVertices.put(4,vertices[4]);
        adjacentVertices.put(5,vertices[5]);
        adjacentVertices.put(6,vertices[6]);
        adjacentVertices.put(7,vertices[7]);
        adjacentVertices.put(8,vertices[8]);
        adjacentVertices.put(9,vertices[9]);
        adjacentVertices.put(10,vertices[10]);
        adjacentVertices.put(11,vertices[11]);
        adjacentVertices.put(12,vertices[12]);
        adjacentVertices.put(13,vertices[13]);
        adjacentVertices.put(14,vertices[14]);
        adjacentVertices.put(15,vertices[15]);


        // if all the vertices are visited, then the Hamiltonian path exists

        if (path.size() == n)
        {
            // print the Hamiltonian path

            if(path.get(0) == selectedNode){
                int length = adjacentVertices.get(selectedNode).length;
                for(int i = 0; i < length; i++){
                    if(path.get(path.size() - 1) == adjacentVertices.get(selectedNode)[i]){
                        allPath.add(path);
                    }
                }
            }
        }

        if(allPath.size() > 0 && z < 1){
            int length = allPath.get(0).size();
            for(int i = 0; i < length; i++){
                if(i == 0){
                    resultCycle += String.valueOf(allPath.get(0).get(i));
                }else{
                    resultCycle += "-->" + String.valueOf(allPath.get(0).get(i));
                }
            }
            resultCycle += "-->" + String.valueOf(selectedNode);
            z++;
        }

        // Check if every edge starting from vertex `v` leads
        // to a solution or not
        for (int w: graph.adjList.get(v))
        {
            // process only unvisited vertices as the Hamiltonian
            // path visit each vertex exactly once
            if (!visited[w])
            {
                visited[w] = true;
                path.add(w);

                // check if adding vertex `w` to the path leads
                // to the solution or not
                hamiltonianPaths(graph, w, visited, path, n, selectedNode);

                // backtrack
                visited[w] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @FXML
    void btnBackClicked(ActionEvent event) {
        ViewInteractor.openScene("start.fxml");
    }

    @FXML
    void btnResetClick(ActionEvent event){
        DisplayBox.setText("Showing Path ...");
        resetButtonColor();
    }

    @FXML
    private Button btn0;
    @FXML
    void btnStartingVertices0(ActionEvent event){
        hamiltonianCycle(0);
        DisplayBox.setText(resultCycle);
        btn0.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn1;
    @FXML
    void btnStartingVertices1(ActionEvent event){
        hamiltonianCycle(1);
        DisplayBox.setText(resultCycle);
        btn1.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn2;
    @FXML
    void btnStartingVertices2(ActionEvent event){
        hamiltonianCycle(2);
        DisplayBox.setText(resultCycle);
        btn2.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn3;
    @FXML
    void btnStartingVertices3(ActionEvent event){
        hamiltonianCycle(3);
        DisplayBox.setText(resultCycle);
        btn3.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn4;
    @FXML
    void btnStartingVertices4(ActionEvent event){
        hamiltonianCycle(4);
        DisplayBox.setText(resultCycle);
        btn4.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn5;
    @FXML
    void btnStartingVertices5(ActionEvent event){
        hamiltonianCycle(5);
        DisplayBox.setText(resultCycle);
        btn5.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn6;
    @FXML
    void btnStartingVertices6(ActionEvent event){
        hamiltonianCycle(6);
        DisplayBox.setText(resultCycle);
        btn6.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn7;
    @FXML
    void btnStartingVertices7(ActionEvent event){
        hamiltonianCycle(7);
        DisplayBox.setText(resultCycle);
        btn7.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn8;
    @FXML
    void btnStartingVertices8(ActionEvent event){
        hamiltonianCycle(8);
        DisplayBox.setText(resultCycle);
        btn8.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn9;
    @FXML
    void btnStartingVertices9(ActionEvent event){
        hamiltonianCycle(9);
        DisplayBox.setText(resultCycle);
        btn9.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn10;
    @FXML
    void btnStartingVertices10(ActionEvent event){
        hamiltonianCycle(10);
        DisplayBox.setText(resultCycle);
        btn10.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn11;
    @FXML
    void btnStartingVertices11(ActionEvent event){
        hamiltonianCycle(11);
        DisplayBox.setText(resultCycle);
        btn11.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn12;
    @FXML
    void btnStartingVertices12(ActionEvent event){
        hamiltonianCycle(12);
        DisplayBox.setText(resultCycle);
        btn12.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn13;
    @FXML
    void btnStartingVertices13(ActionEvent event){
        hamiltonianCycle(13);
        DisplayBox.setText(resultCycle);
        btn13.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn14;
    @FXML
    void btnStartingVertices14(ActionEvent event){
        hamiltonianCycle(14);
        DisplayBox.setText(resultCycle);
        btn14.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
    }

    @FXML
    private Button btn15;
    @FXML
    void btnStartingVertices15(ActionEvent event){
        hamiltonianCycle(15);
        DisplayBox.setText(resultCycle);
        btn15.setStyle("-fx-background-color: #403535; -fx-text-fill: #FFECCF;");
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
}

// A class to store a graph edge
class Edge
{
    int source, dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    java.util.List<java.util.List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
