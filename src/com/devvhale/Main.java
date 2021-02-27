package com.devvhale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The number of vertices: ");
        int V = scanner.nextInt();

        Graph graph = new Graph(V); // undirected graph
        for(int i = 0; i < V; i++) {
            System.out.print("Source and destination for vertex: ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.display();
    }
}
