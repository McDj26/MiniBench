package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ArrayCombinationTest {

    @Test
    public void combinationTest() {
        // Test case 1: Standard case
        List<TreeSet<Integer>> result = ArrayCombination.combination(4, 2);
        List<TreeSet<Integer>> expected = Arrays.asList(
            new TreeSet<>(Arrays.asList(1, 2)),
            new TreeSet<>(Arrays.asList(1, 3)),
            new TreeSet<>(Arrays.asList(1, 4)),
            new TreeSet<>(Arrays.asList(2, 3)),
            new TreeSet<>(Arrays.asList(2, 4)),
            new TreeSet<>(Arrays.asList(3, 4))
        );
        assertEquals(expected, result);

        // Test case 2: Single element case
        result = ArrayCombination.combination(1, 1);
        expected = Arrays.asList(new TreeSet<>(Collections.singletonList(1)));
        assertEquals(expected, result);

        // Test case 3: k is 0 (should return null)
        result = ArrayCombination.combination(4, 0);
        assertNull(result, "Combination should be null when k is 0");

        // Test case 4: n is less than or equal to 0 (should return null)
        result = ArrayCombination.combination(0, 2);
        assertNull(result, "Combination should be null when n is <= 0");
        result = ArrayCombination.combination(-1, 2);
        assertNull(result, "Combination should be null when n is <= 0");

        // Test case 5: k is greater than n (should return an empty list)
        result = ArrayCombination.combination(2, 3);
        expected = Collections.emptyList();
        assertEquals(expected, result, "Combination should be empty when k > n");
    }
}