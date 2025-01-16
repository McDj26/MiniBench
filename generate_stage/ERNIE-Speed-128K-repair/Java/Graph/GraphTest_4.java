package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class GraphTest {
    @Test
    public void countGraphsTest() {
        // Create a Graph instance
        Graph graph = new Graph();
        // Add nodes and edges to build a simple graph
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D"); // Creating a cycle in the graph
        graph.addEdge("E", "F"); // Adding another disconnected component
        
        // Perform the test
        int expectedComponents = 2; // Since there are two disconnected components in the graph
        int actualComponents = graph.countGraphs();
        assertEquals(expectedComponents, actualComponents, "The number of connected components should be " + expectedComponents);
    }
}

In the given test case, I have created a simple graph with five nodes and six edges to demonstrate the use of the `countGraphs()` method. The graph has two disconnected components: one cycle (A, B, C, D) and a separate node E with a connected node F. The expected number of connected components is 2, and we assert that the `countGraphs()` method returns the correct value.