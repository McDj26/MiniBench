package com.thealgorithms.datastructures.graphs;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class AdjacencyList<E> {
    Map<E, ArrayList<E>> adj = new HashMap<>();

    public AdjacencyList() {
    }

    public void addEdge(E from, E to) {
        adj.putIfAbsent(from, new ArrayList<>());
        adj.get(from).add(to);
    }

    public ArrayList<E> getAdjacents(E v) {
        return adj.getOrDefault(v, new ArrayList<>());
    }

    public Set<E> getVertices() {
        return adj.keySet();
    }

    public void printGraph() {
        for (Map.Entry<E, ArrayList<E>> entry : adj.entrySet()) {
            System.out.println("Vertex: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}

class TopologicalSort<E> {
    AdjacencyList<E> graph;
    Map<E, Integer> inDegree;

    public TopologicalSort(AdjacencyList<E> graph) {
        this.graph = graph;
        this.inDegree = new HashMap<>();
    }

    public void calculateInDegree() {
        for (E vertex : graph.getVertices()) {
            inDegree.put(vertex, 0);
        }
        for (E vertex : graph.getVertices()) {
            for (E adjacent : graph.getAdjacents(vertex)) {
                inDegree.put(adjacent, inDegree.get(adjacent) + 1);
            }
        }
    }

    public ArrayList<E> topSortOrder() {
        calculateInDegree();
        Queue<E> q = new LinkedList<E>();
        for (E vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                q.add(vertex);
            }
        }
        ArrayList<E> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            E current = q.poll();
            answer.add(current);
            for (E adjacent : graph.getAdjacents(current)) {
                inDegree.put(adjacent, inDegree.get(adjacent) - 1);
                if (inDegree.get(adjacent) == 0) {
                    q.add(adjacent);
                }
            }
        }
        return answer;
    }
}

public class KahnsAlgorithmTest {

    @Test
    public void topSortOrderTest() {
        AdjacencyList<Integer> graph = new AdjacencyList<>();
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopologicalSort<Integer> topologicalSort = new TopologicalSort<>(graph);
        ArrayList<Integer> result = topologicalSort.topSortOrder();

        // There are multiple valid topological orders for this graph.
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(5, 4, 2, 3, 1, 0));
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(4, 5, 2, 3, 0, 1));
        
        assertTrue(result.equals(expected1) || result.equals(expected2), "The topological order is not correct.");
    }
}