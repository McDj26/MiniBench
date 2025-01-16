package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GraphTest {

    @Test
    public void countGraphsTest() {
        // Create a new graph
        Graph graph = new Graph();

        // Add nodes and edges
        // First connected component: node1, node2, node3
        graph.addEdge("node1", "node2");
        graph.addEdge("node2", "node3");

        // Second connected component: node4, node5
        graph.addEdge("node4", "node5");

        // Single node: node6 as its own connected component
        graph.nodeList.add(graph.new Node("node6"));

        // Calculate the number of connected components
        int numOfGraphs = graph.countGraphs();

        // Assert that the result matches the expected value (3 in this case)
        assertEquals(3, numOfGraphs);
    }
}