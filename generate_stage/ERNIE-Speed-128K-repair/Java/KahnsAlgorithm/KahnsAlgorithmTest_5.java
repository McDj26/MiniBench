package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class KahnsAlgorithmTest {
    @Test
    public void topSortOrderTest() {
        // Step 1: Create an adjacency list and populate it with edges
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6); // The graph is represented as a DAG (Directed Acyclic Graph) for this test case
        TopologicalSort topoSort = new TopologicalSort(graph); // Step 2: Create a TopologicalSort object with the graph
        ArrayList<Integer> expectedOrder = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)); // Expected topological order based on the graph structure
        ArrayList<Integer> actualOrder = topoSort.topSortOrder(); // Step 3: Perform topological sort and store the result in actualOrder
        Assertions.assertEquals(expectedOrder, actualOrder, "Topological sort order is not correct"); // Step 4: Assert that the actual order matches the expected order
    }
}