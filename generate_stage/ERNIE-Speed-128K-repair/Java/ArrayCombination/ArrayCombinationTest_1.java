package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayCombinationTest {
    @Test
    public void combinationTest() {
        // Test case for combination function with n = 3 and k = 2
        int n = 3;
        int k = 2;
        List<TreeSet<Integer>> combinations = ArrayCombination.combination(n, k);
        assertNotNull(combinations); // Assert that the combinations list is not null
        assertEquals(2, combinations.size()); // Assert that the list has two combinations
        assertTrue(combinations.contains(new TreeSet<>(Arrays.asList(1, 2))); // Assert that one combination is {1, 2}
        assertTrue(combinations.contains(new TreeSet<>(Arrays.asList(1, 3))); // Assert that another combination is {1, 3}
    }
    
    // Additional test case for combination function with n = 5 and k = 3
    @Test
    public void combinationTestWithN5K3() {
        int n = 5;
        int k = 3;
        List<TreeSet<Integer>> combinations = ArrayCombination.combination(n, k);
        assertNotNull(combinations); // Assert that the combinations list is not null
        assertEquals(10, combinations.size()); // Assert that there are 10 unique combinations of length 3 from 1 to 5
        // Test some of the combinations (partial list to be completed with other possible combinations)
        assertTrue(combinations.contains(new TreeSet<>(Arrays.asList(1, 2, 3))); // Combination {1, 2, 3} should be present
        assertTrue(combinations.contains(new TreeSet<>(Arrays.asList(1, 4, 5))); // Combination {1, 4, 5} should be present
        // Add more assertions for other combinations to complete the test case
    }
}