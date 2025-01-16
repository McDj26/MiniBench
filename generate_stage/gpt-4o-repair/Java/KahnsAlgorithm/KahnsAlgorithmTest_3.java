package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class KahnsAlgorithmTest {

    @Test
    public void topSortOrderTest() {
        // Setup
        AdjacencyList<String> adjList = new AdjacencyList<>();
        adjList.addEdge("A", "C");
        adjList.addEdge("B", "C");
        adjList.addEdge("C", "E");
        adjList.addEdge("B", "D");
        adjList.addEdge("D", "F");
        
        TopologicalSort<String> topoSort = new TopologicalSort<>(adjList);
        
        // Test topSortOrder
        ArrayList<String> result = topoSort.topSortOrder();
        
        // Expected topological order (one of the possible orders)
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "B", "D", "C", "F", "E"));
        
        // Verify result (There might be multiple valid topological sorts)
        assertTrue(isValidTopologicalSort(expected, result, adjList));
    }
    
    private boolean isValidTopologicalSort(ArrayList<String> expected, ArrayList<String> result, AdjacencyList<String> adjList) {
        if (expected.size() != result.size()) {
            return false;
        }
        
        Map<String, Integer> position = new LinkedHashMap<>();
        for (int i = 0; i < result.size(); i++) {
            position.put(result.get(i), i);
        }
        
        for (String vertex : adjList.getVertices()) {
            for (String adjacent : adjList.getAdjacents(vertex)) {
                if (position.get(vertex) > position.get(adjacent)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}