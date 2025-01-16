package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class KahnsAlgorithmTest {
    @Test
    public void topSortOrderTest() {
        // Arrange
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(1, 2); // 1 -> 2
        graph.addEdge(2, 3); // 2 -> 3
        graph.addEdge(1, 3); // 1 -> 3 (dependency added to simulate a circular graph)
        TopologicalSort topologicalSort = new TopologicalSort<>(graph);
        topologicalSort.calculateInDegree(); // Assuming this method calculates the inDegree correctly for each vertex in the graph
        ArrayList<Integer> expectedOrder = new ArrayList<>(); // Expected topological order
        expectedOrder.add(1); // Add the vertices to simulate expected topological order result (correct one for the given graph)
        expectedOrder.add(2); // Add vertices based on the actual dependency structure in the graph
        expectedOrder.add(3); // Adding the remaining vertex to complete the expected order
        ArrayList<Integer> actualOrder = topologicalSort.topSortOrder(); // Act
        // Assert
        assertEquals(expectedOrder, actualOrder, "Topological sort order is not correct."); // Assert that actual order matches expected order
    }
}