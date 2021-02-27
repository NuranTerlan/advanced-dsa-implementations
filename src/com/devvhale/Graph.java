package com.devvhale;

import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    void display() {
        for(int i = 0; i < vertices; i++) {
            int listSize = adjList[i].size();
            if(listSize > 0) {
                System.out.print(String.format("Vertex %s is connected to: ", i));
                for(int j = 0; j < listSize; j++) {
                    System.out.print(adjList[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
