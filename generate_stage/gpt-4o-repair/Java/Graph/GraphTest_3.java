package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class GraphTest {
    
    @Test
    public void countGraphsTest() {
        Graph<Integer> graph = new Graph<>();
        
        // Define nodes
        Graph<Integer>.Node node1 = graph.new Node(1);
        Graph<Integer>.Node node2 = graph.new Node(2);
        Graph<Integer>.Node node3 = graph.new Node(3);
        Graph<Integer>.Node node4 = graph.new Node(4);
        
        // Populate node list
        graph.nodeList = new ArrayList<>();
        graph.nodeList.add(node1);
        graph.nodeList.add(node2);
        graph.nodeList.add(node3);
        graph.nodeList.add(node4);
        
        // Add edges to create two separate connected components
        graph.edgeList = new ArrayList<>();
        graph.addEdge(1, 2); // First component: 1 - 2
        graph.addEdge(3, 4); // Second component: 3 - 4
        
        // Test the countGraphs method
        int expectedConnectedComponents = 2;
        assertEquals(expectedConnectedComponents, graph.countGraphs());
    }
}