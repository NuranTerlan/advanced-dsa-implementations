package com.devvhale;

import java.util.LinkedList;

class Node {
    private final int id;
    private final LinkedList<Node> adjacent;

    Node(int id) {
        this.id = id;
        adjacent = new LinkedList<>();
    }

    int getId() {
        return id;
    }

    LinkedList<Node> getAdjacent() {
        return adjacent;
    }

    void setAdjacent(Node node) {
        adjacent.add(node);
    }
}
