package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GraphTest {

    @Test
    public void countGraphsTest() {
        Graph<String> graph = new Graph<>();

        // Define nodes
        Graph.Node nodeA = graph.new Node("A");
        Graph.Node nodeB = graph.new Node("B");
        Graph.Node nodeC = graph.new Node("C");
        Graph.Node nodeD = graph.new Node("D");
        Graph.Node nodeE = graph.new Node("E");

        // Add nodes to graph's nodeList
        graph.nodeList.add(nodeA);
        graph.nodeList.add(nodeB);
        graph.nodeList.add(nodeC);
        graph.nodeList.add(nodeD);
        graph.nodeList.add(nodeE);

        // Define edges for two connected components: A-B-C and D-E
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeD, nodeE);

        // Calculate the number of connected components
        int numberOfGraphs = graph.countGraphs();

        // Assert that there are 2 connected components
        assertEquals(2, numberOfGraphs);
    }
}