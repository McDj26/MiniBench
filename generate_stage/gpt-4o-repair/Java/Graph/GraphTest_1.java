package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class GraphTest {

    @Test
    public void countGraphsTest() {
        // Test case 1: Empty graph
        Graph emptyGraph = new Graph();
        assertEquals(0, emptyGraph.countGraphs(), "An empty graph should have 0 components");

        // Test case 2: One node graph
        Graph singleNodeGraph = new Graph();
        singleNodeGraph.addEdge("A", "A");
        assertEquals(1, singleNodeGraph.countGraphs(), "A single node graph should have 1 component");

        // Test case 3: Connected graph
        Graph connectedGraph = new Graph();
        connectedGraph.addEdge("A", "B");
        connectedGraph.addEdge("B", "C");
        connectedGraph.addEdge("C", "D");
        assertEquals(1, connectedGraph.countGraphs(), "A connected graph should have 1 component");

        // Test case 4: Disconnected graph
        Graph disconnectedGraph = new Graph();
        disconnectedGraph.addEdge("A", "B");
        disconnectedGraph.addEdge("C", "D");
        disconnectedGraph.addEdge("E", "F");
        assertEquals(3, disconnectedGraph.countGraphs(), "A disconnected graph with 3 isolated components should have 3 components");

        // Test case 5: Mixed graph
        Graph mixedGraph = new Graph();
        mixedGraph.addEdge("A", "B");
        mixedGraph.addEdge("C", "D");
        mixedGraph.addEdge("D", "E");
        mixedGraph.addEdge("F", "G");
        assertEquals(3, mixedGraph.countGraphs(), "A mixed graph with 3 components should have 3 components");
    }
}