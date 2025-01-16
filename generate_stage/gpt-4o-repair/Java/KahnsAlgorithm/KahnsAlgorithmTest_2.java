package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class KahnsAlgorithmTest {

    @Test
    public void topSortOrderTest() {
        // Create an instance of AdjacencyList and add edges to form a test graph
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        
        // Add edges to the graph
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        
        // Create an instance of TopologicalSort with the created graph
        TopologicalSort<Integer> topSort = new TopologicalSort<>(graph);
        
        // Get the topological order using topSortOrder method
        ArrayList<Integer> result = topSort.topSortOrder();
        
        // Specify the expected topological order
        ArrayList<Integer> expectedOrder1 = new ArrayList<>(Arrays.asList(4, 5, 0, 2, 3, 1));
        ArrayList<Integer> expectedOrder2 = new ArrayList<>(Arrays.asList(5, 4, 2, 3, 1, 0));
        
        // There can be multiple valid topological orders. So you can test against one of them.
        assertTrue(result.equals(expectedOrder1) || result.equals(expectedOrder2), "The topological order is incorrect.");
    }
}