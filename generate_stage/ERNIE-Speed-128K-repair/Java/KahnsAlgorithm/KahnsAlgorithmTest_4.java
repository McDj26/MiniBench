package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class KahnsAlgorithmTest {
    @Test
    public void topSortOrderTest() {
        // Arrange
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(1, 2); // Add edges to form a directed graph for testing
        graph.addEdge(1, 3); // In this case, it would form a DAG (Directed Acyclic Graph)
        graph.addEdge(2, 4); // where vertices can be arranged in a topological order
        graph.addEdge(3, 4); // Topological order is a linear ordering of vertices such that for every directed edge uv, u comes before v in the order.
        TopologicalSort<Integer> topoSort = new TopologicalSort<>(graph);
        topoSort.calculateInDegree(); // Call the method to calculate in-degrees of vertices
        ArrayList<Integer> expectedOrder = new ArrayList<>(); // Initialize an expected order of vertices in topological sort
        expectedOrder.add(1); // Add vertices in the expected order
        expectedOrder.add(2); // Add more vertices based on the graph structure and expected flow of edges
        expectedOrder.add(3); // Note: This is just an example expected order based on the provided graph structure
        expectedOrder.add(4); // The actual expected order may vary depending on the graph's structure and edges

        // Act & Assert
        ArrayList<Integer> actualOrder = topoSort.topSortOrder(); // Call the method to get the actual topological sort order
        assertNotNull(actualOrder); // Ensure the returned list is not null
        assertEquals(expectedOrder.size(), actualOrder.size()); // Assert that the size of actual and expected orders are the same
        for (int i = 0; i < expectedOrder.size(); i++) { // Iterate over each vertex in the expected order
            assertEquals(expectedOrder.get(i), actualOrder.get(i)); // Assert that each vertex in the actual order matches its corresponding vertex in the expected order
        }
    }
}