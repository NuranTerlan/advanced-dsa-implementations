package com.devvhale;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph2 {
    private HashMap<Integer, Node> nodeLookup;

    public Graph2() {
        nodeLookup = new HashMap<>();
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    private Node[] getEdgeProps(int source, int destination) {
        Node src = getNode(source);
        Node dest = getNode(destination);
        Node[] edgeProps = {src, dest};

        return edgeProps; // [sourceNode, destinationNode]
    }

    public void addNode(int id) {
        var node = new Node(id);
        nodeLookup.put(id, node);
    }

    public void addEdge(int source, int destination) {
        var edgeProps = getEdgeProps(source, destination);
        edgeProps[0].setAdjacent(edgeProps[1]);
    }

    public boolean hasPathDFS(int source, int destination) {
        var edgeProps = getEdgeProps(source, destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(edgeProps[0], edgeProps[1], visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.getId())) return false;
        visited.add(source.getId());
        if (source == destination) return true;
        for (var child : source.getAdjacent())
            if (hasPathDFS(child, destination, visited)) return true;

        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        var edgeProps = getEdgeProps(source, destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathBFS(edgeProps[0], edgeProps[1], visited);
    }

    private boolean hasPathBFS(Node source, Node destination, HashSet<Integer> visited) {
        LinkedList<Node> nextToExplore = new LinkedList<>();
        nextToExplore.add(source);
        while (!nextToExplore.isEmpty()) {
            var node = nextToExplore.remove(); // remove and get first item
            if (node == destination) return true;
            if (visited.contains(node.getId())) continue;
            visited.add(node.getId());
            for (var child : node.getAdjacent())
                nextToExplore.add(child);
        }
        return false;
    }

    public void display() {
        for (int i : nodeLookup.keySet()) {
            var adjacent = nodeLookup.get(i).getAdjacent();
            int adjacentSize = adjacent.size();
            if (adjacentSize > 0) {
                System.out.print(String.format("Vertex %s is connected to: ", i));
                for (var adj : adjacent) {
                    System.out.print(adj.getId() + " ");
                }
                System.out.println();
            }
        }
    }
}
