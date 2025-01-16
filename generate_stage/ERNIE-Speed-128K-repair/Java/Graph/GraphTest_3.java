package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void countGraphsTest() {
        // Arrange
        Graph graph = new Graph(); // Initialize a new graph instance
        Node node1 = new Graph.Node("Node1"); // Create nodes for the graph
        Node node2 = new Graph.Node("Node2");
        Node node3 = new Graph.Node("Node3");
        Node node4 = new Graph.Node("Node4");
        graph.addEdge(node1, node2); // Add edges to form a connected graph
        graph.addEdge(node2, node3);
        graph.addEdge(node3, node4); // Add edge to form a second connected component
        graph.addEdge(node4, node1); // This edge should not be counted in the component count
        assertEquals(graph.countGraphs(), 2); // Assert that there are two connected components initially
        assertEquals(graph.nodeList.size(), 4); // Assert that there are four nodes in the graph
        assertEquals(graph.edgeList.size(), 4); // Assert that there are four edges in the graph
        // Now we remove edges to create a disconnected graph and test countGraphs method again
        graph.removeEdge(node2, node3); // Remove an edge to disconnect the graph into two components
        assertEquals(graph.countGraphs(), 3); // Assert that there are now three connected components
    }
}