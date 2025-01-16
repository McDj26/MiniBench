package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ArrayCombinationTest {

    @Test
    public void combinationTest() {
        // Test when n is 0, expect null
        assertNull(ArrayCombination.combination(0, 1), "Combination of 0 length array should be null.");

        // Test when k is 0, expect null
        assertNull(ArrayCombination.combination(3, 0), "Combination with 0 element length should be null.");

        // Test when n < k, should be empty because you can't choose k elements out of n
        assertEquals(0, ArrayCombination.combination(2, 3).size(), "Cannot choose 3 elements from 1 to 2.");

        // Test typical case n = 4, k = 2
        List<TreeSet<Integer>> expected = new ArrayList<>();
        expected.add(new TreeSet<>(Arrays.asList(1, 2)));
        expected.add(new TreeSet<>(Arrays.asList(1, 3)));
        expected.add(new TreeSet<>(Arrays.asList(1, 4)));
        expected.add(new TreeSet<>(Arrays.asList(2, 3)));
        expected.add(new TreeSet<>(Arrays.asList(2, 4)));
        expected.add(new TreeSet<>(Arrays.asList(3, 4)));

        List<TreeSet<Integer>> result = ArrayCombination.combination(4, 2);
        assertEquals(expected.size(), result.size(), "Number of combinations of 4 choose 2 is wrong.");
        assertTrue(result.containsAll(expected), "Combinations do not match expected results.");
    }
}