package com.example.worldoftitan;

import java.util.*;

public class Graph {
    private final int vertices;
    private final ArrayList<Boolean> vertexList;
    private final ArrayList<ArrayList<Integer>> adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.vertexList = new ArrayList<>();
        this.adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) vertexList.add(false);
        for (int i = 0; i < vertices; i++) adj.add(new ArrayList<>());
    }

    public void setOccupation(int position, boolean state) {
        this.vertexList.set(position, state);
    }

    public boolean getOccupation(int position) {
        return this.vertexList.get(position);
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public ArrayList<Integer> printShortestPath(int source, int dest) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

        for (int i = 0; i < vertices; i++) parent.add(new ArrayList<>());

        BFS(parent, source);
        searchPaths(paths, path, parent, dest);

        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> x : paths) {
            Collections.reverse(x);
            list = x;
            return list;
        }
        return list;
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