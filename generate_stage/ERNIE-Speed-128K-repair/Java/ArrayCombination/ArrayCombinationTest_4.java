package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayCombinationTest {
    @Test
    public void combinationTest() {
        // Test case for n = 5 and k = 3
        int n = 5;
        int k = 3;
        List<TreeSet<Integer>> combinations = ArrayCombination.combination(n, k);
        assertNotNull(combinations); // Assert that the result is not null
        assertFalse(combinations.isEmpty()); // Assert that the list is not empty
        assertEquals(combinations.size(), 5); // Assert that there are 5 combinations for n=5 and k=3
        for (TreeSet<Integer> combination : combinations) {
            assertEquals(combination.size(), k); // Assert that each combination has k elements
            assertTrue(combination.containsAll(Arrays.asList(1, 2, 3)); // Assert that each combination contains numbers from 1 to k (inclusive)
        }
        // Additional test case for n = 3 and k = 2
        List<TreeSet<Integer>> combinations2 = ArrayCombination.combination(3, 2);
        assertNotNull(combinations2); // Assert that the result is not null for this case too
        assertFalse(combinations2.isEmpty()); // Assert that the list is not empty for this case too
        assertEquals(combinations2.size(), 3); // Assert that there are 3 combinations for n=3 and k=2
        // Add more test cases if necessary to cover different scenarios and edge cases
    }
}