package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import java.util.*;

public class KahnsAlgorithmTest {
    @Test
    public void topSortOrderTest() {
        // Create an instance of AdjacencyList and add edges to form a graph
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Create an instance of TopologicalSort and calculate the topSortOrder
        TopologicalSort<Integer> topoSort = new TopologicalSort<>(graph);
        ArrayList<Integer> topOrder = topoSort.topSortOrder();

        // Expected topological order (one possible result)
        ArrayList<Integer> expectedOrder = new ArrayList<>();
        expectedOrder.add(1); // First node with zero in-degree
        expectedOrder.add(2); // First node with zero in-degree after removing node 1
        expectedOrder.add(3); // First node with zero in-degree after removing nodes 1 and 2
        expectedOrder.add(4); // Nodes adjacent to node 3 have already been processed
        expectedOrder.add(5); // Last node in the graph

        // Assertions to check if the topSortOrder matches the expected order
        assertEquals(expectedOrder.size(), topOrder.size(), "The size of expected and actual orders should be equal.");
        for (int i = 0; i < expectedOrder.size(); i++) {
            assertEquals(expectedOrder.get(i), topOrder.get(i), "The elements at index " + i + " should match.");
        }
    }
}