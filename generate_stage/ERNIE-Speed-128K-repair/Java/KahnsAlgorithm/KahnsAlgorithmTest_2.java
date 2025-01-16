package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class KahnsAlgorithmTest {
    @Test
    public void topSortOrderTest() {
        // Arrange
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(1, 2); // 1 -> 2
        graph.addEdge(1, 3); // 1 -> 3
        graph.addEdge(2, 4); // 2 -> 4
        graph.addEdge(3, 4); // 3 -> 4
        TopologicalSort topologicalSort = new TopologicalSort<>(graph);
        topologicalSort.calculateInDegree(); // Precondition for topSortOrder method
        ArrayList<Integer> expectedOrder = new ArrayList<>(); // Expected topological order
        expectedOrder.add(1); // Start with vertices having in-degree zero (in this case, vertex 1)
        expectedOrder.add(2); // Add adjacent vertices to the queue as they become available
        expectedOrder.add(3); // Add adjacent vertices to the queue as they become available
        expectedOrder.add(4); // Add the last vertex to complete the topological order
        ArrayList<Integer> actualOrder = topologicalSort.topSortOrder(); // Call the method to test
        Assertions.assertNotNull(actualOrder); // Ensure the result is not null
        Assertions.assertEquals(expectedOrder, actualOrder); // Assert that the actual order matches the expected order
    }
}