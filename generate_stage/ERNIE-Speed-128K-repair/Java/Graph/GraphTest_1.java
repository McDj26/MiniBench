package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GraphTest {

    @Test
    public void countGraphsTest() {
        // Arrange
        Graph graph = new Graph(); // Assuming the Graph class has a default constructor
        Node node1 = new Node("A"); // Assuming 'A' is the name for node 1
        Node node2 = new Node("B"); // Assuming 'B' is the name for node 2
        Node node3 = new Node("C"); // Assuming 'C' is the name for node 3
        graph.addEdge(node1, node2); // Assuming this creates an edge between node 1 and node 2
        graph.addEdge(node2, node3); // Assuming this creates an edge between node 2 and node 3
        graph.addEdge(node3, node1); // Assuming this creates a cycle (node 3 is connected to node 1)
        graph.addEdge(node1, node1); // This should be ignored since it is a self-loop or a duplicate edge (your logic may differ)
        // Initialize other nodes in nodeList and other test setup logic here if necessary...
        int expectedCount = 1; // Assuming there is only one connected component in the graph
        int actualCount = graph.countGraphs(); // Perform the actual count operation
        // Assert
        assertEquals(expectedCount, actualCount, "The number of connected components should be " + expectedCount);
    }
}