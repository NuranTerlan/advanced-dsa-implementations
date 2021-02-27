package com.devvhale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        /*System.out.print("The number of vertices: ");
        int V = scanner.nextInt();

        Graph1 graph1 = new Graph1(V); // undirected graph
        for(int i = 0; i < V; i++) {
            System.out.print("Source and destination for vertex: ");
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph1.addEdge(source, destination);
        }

        graph1.display();*/

        Graph2 graph2 = new Graph2();
        for (int i = 1; i <= 8; i++) {
            graph2.addNode(i);
        }
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(1, 6);
        graph2.addEdge(3, 2);
        graph2.addEdge(3, 6);
        graph2.addEdge(4, 6);
        graph2.addEdge(6, 5);
        graph2.addEdge(6, 8);
        graph2.addEdge(8, 7);

        graph2.display();
        System.out.println(graph2.hasPathBFS(3, 2));
    }
}
