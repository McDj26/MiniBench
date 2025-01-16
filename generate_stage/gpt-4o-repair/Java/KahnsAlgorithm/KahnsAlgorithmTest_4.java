package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class KahnsAlgorithmTest {

    @Test
    public void topSortOrderTest() {
        // Create a new adjacency list for the graph
        AdjacencyList<String> graph = new AdjacencyList<>();

        // Add edges to the graph
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("E", "F");
        graph.addEdge("D", "F");
        
        // Create a topological sort instance with the graph
        TopologicalSort<String> topologicalSort = new TopologicalSort<>(graph);

        // Expected result after topological sorting
        ArrayList<String> expectedOrder1 = new ArrayList<>();
        expectedOrder1.add("A");
        expectedOrder1.add("B");
        expectedOrder1.add("C");
        expectedOrder1.add("D");
        expectedOrder1.add("E");
        expectedOrder1.add("F");
        
        ArrayList<String> expectedOrder2 = new ArrayList<>();
        expectedOrder2.add("B");
        expectedOrder2.add("A");
        expectedOrder2.add("C");
        expectedOrder2.add("D");
        expectedOrder2.add("E");
        expectedOrder2.add("F");

        // Perform the topological sort
        ArrayList<String> order = topologicalSort.topSortOrder();

        // Check if the result is a valid topological sort
        assertTrue(order.equals(expectedOrder1) || order.equals(expectedOrder2),
                "The topological sort order is incorrect.");
    }
}