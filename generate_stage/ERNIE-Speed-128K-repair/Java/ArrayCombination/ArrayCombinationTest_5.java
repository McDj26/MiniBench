package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayCombinationTest {
    @Test
    public void combinationTest() {
        int n = 5; // Maximum value of the array
        int k = 3; // Length of combination to find
        List<TreeSet<Integer>> combinations = ArrayCombination.combination(n, k);
        assertNotNull(combinations); // Assert that the result is not null
        assertFalse(combinations.isEmpty()); // Assert that the list is not empty
        assertEquals(5, combinations.size()); // Assert that there are 5 combinations for n=5 and k=3
        for (TreeSet<Integer> combination : combinations) {
            assertTrue(combination.size() == k); // Assert that each combination has the correct length
            for (int i = 1; i <= n; i++) { // Assert that each combination contains numbers from 1 to n
                assertTrue(combination.contains(i));
            }
        }
    }
}