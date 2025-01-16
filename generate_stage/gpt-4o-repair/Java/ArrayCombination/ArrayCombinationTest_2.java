package com.thealgorithms.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.TreeSet;

public class ArrayCombinationTest {

    @Test
    public void combinationTest() {
        // Test with valid n and k
        List<TreeSet<Integer>> result = ArrayCombination.combination(4, 2);
        assertNotNull(result);
        assertEquals(6, result.size());

        // Expected combinations: [1,2], [1,3], [1,4], [2,3], [2,4], [3,4]
        assertTrue(result.contains(new TreeSet<>(List.of(1, 2))));
        assertTrue(result.contains(new TreeSet<>(List.of(1, 3))));
        assertTrue(result.contains(new TreeSet<>(List.of(1, 4))));
        assertTrue(result.contains(new TreeSet<>(List.of(2, 3))));
        assertTrue(result.contains(new TreeSet<>(List.of(2, 4))));
        assertTrue(result.contains(new TreeSet<>(List.of(3, 4))));

        // Test case where k is 0
        result = ArrayCombination.combination(4, 0);
        assertNull(result);

        // Test case where n is 0
        result = ArrayCombination.combination(0, 2);
        assertNull(result);

        // Test case where k is greater than n
        result = ArrayCombination.combination(3, 4);
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}