package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void countGraphsTest() {
        // Arrange
        Graph graph = new Graph(); // Initialize a new graph instance
        Node node1 = new Graph.Node("Node1"); // Create some nodes and add them to the graph
        Node node2 = new Graph.Node("Node2");
        Node node3 = new Graph.Node("Node3");
        graph.addEdge(node1, node2); // Add edges to form a connected graph
        graph.addEdge(node2, node3);
        assertEquals(0, graph.countGraphs()); // This will throw an error because there are not multiple graphs
        // Perform operations to break the graph into multiple connected components (to be tested)
        // For example, removing an edge between node1 and node2 to break the graph into two connected components
        graph.removeEdge(node1, node2); // Assuming this method exists and can remove edges
        assertEquals(2, graph.countGraphs()); // Now there should be two connected components (graphs)
    }
}