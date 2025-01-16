package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {
    @Test
    public void countGraphsTest() {
        // Create a Graph instance
        Graph graph = new Graph();
        
        // Add nodes and edges to build a graph with multiple connected components
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E"); // This edge creates a separate connected component
        graph.addEdge("F", "G"); // This is a disconnected component with only one node each
        graph.addEdge("H", "I"); // Another disconnected component
        
        // Test countGraphs method to determine the number of connected components
        int numOfGraphs = graph.countGraphs();
        assertEquals(3, numOfGraphs); // Expecting 3 connected components in this graph
    }
}

Explanation:
In this test case, we first create an instance of the Graph class. Then, we add edges to form a graph with multiple connected components and disconnected nodes. After that, we call the countGraphs method to determine the number of connected components in the graph and assert that the expected number of connected components is 3 in this case.