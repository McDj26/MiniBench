package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class KahnsAlgorithmTest {

    @Test
    public void topSortOrderTest() {
        // Arrange
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>(graph);

        // Act
        ArrayList<Integer> result = topologicalSort.topSortOrder();

        // Assert
        assertNotNull(result, "The result should not be null");

        // Expected result could have multiple valid topological orders. Here is one:
        ArrayList<Integer> expectedOrder1 = new ArrayList<>(Arrays.asList(4, 5, 2, 0, 3, 1));
        ArrayList<Integer> expectedOrder2 = new ArrayList<>(Arrays.asList(5, 4, 2, 0, 3, 1));
        ArrayList<Integer> expectedOrder3 = new ArrayList<>(Arrays.asList(5, 4, 0, 2, 3, 1));

        // Check if the result matches any of the expected valid orders
        assertTrue(result.equals(expectedOrder1) || result.equals(expectedOrder2) || result.equals(expectedOrder3),
                "The topological sort order is incorrect");
    }
}