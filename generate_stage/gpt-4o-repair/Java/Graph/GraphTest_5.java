package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    @Test
    public void countGraphsTest() {
        // Create an instance of the Graph
        Graph graph = new Graph();

        // Create nodes
        Graph.Node nodeA = graph.new Node("A");
        Graph.Node nodeB = graph.new Node("B");
        Graph.Node nodeC = graph.new Node("C");
        Graph.Node nodeD = graph.new Node("D");
        Graph.Node nodeE = graph.new Node("E");

        // Add nodes to the graph's nodeList
        graph.nodeList = new ArrayList<>();
        graph.nodeList.add(nodeA);
        graph.nodeList.add(nodeB);
        graph.nodeList.add(nodeC);
        graph.nodeList.add(nodeD);
        graph.nodeList.add(nodeE);

        // Initialize graph's edge list
        graph.edgeList = new ArrayList<>();
        
        // Connect nodes A and B (component 1)
        graph.addEdge(nodeA.name, nodeB.name);

        // Connect nodes D and E (component 2)
        graph.addEdge(nodeD.name, nodeE.name);

        // Call countGraphs and verify the result
        int count = graph.countGraphs();

        // Verify that the method correctly identifies two connected components
        assertEquals(3, count, "The graph should be divided into 3 components: {A, B}, {C}, and {D, E}");
    }
}