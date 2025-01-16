package com.thealgorithms.backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.TreeSet;

public class ArrayCombinationTest {

    @Test
    public void combinationTest() {
        // Test case when n = 4, k = 2.
        List<TreeSet<Integer>> result1 = ArrayCombination.combination(4, 2);
        assertNotNull(result1);
        assertEquals(6, result1.size());
        assertTrue(result1.contains(new TreeSet<>(List.of(1, 2))));
        assertTrue(result1.contains(new TreeSet<>(List.of(1, 3))));
        assertTrue(result1.contains(new TreeSet<>(List.of(1, 4))));
        assertTrue(result1.contains(new TreeSet<>(List.of(2, 3))));
        assertTrue(result1.contains(new TreeSet<>(List.of(2, 4))));
        assertTrue(result1.contains(new TreeSet<>(List.of(3, 4))));

        // Test case when n = 0, k = 2.
        assertNull(ArrayCombination.combination(0, 2));

        // Test case when n = 4, k = 0.
        assertNull(ArrayCombination.combination(4, 0));

        // Test case when n = -1, k = 2.
        assertNull(ArrayCombination.combination(-1, 2));

        // Test case when n = 4, k = 1.
        List<TreeSet<Integer>> result2 = ArrayCombination.combination(4, 1);
        assertNotNull(result2);
        assertEquals(4, result2.size());
        assertTrue(result2.contains(new TreeSet<>(List.of(1))));
        assertTrue(result2.contains(new TreeSet<>(List.of(2))));
        assertTrue(result2.contains(new TreeSet<>(List.of(3))));
        assertTrue(result2.contains(new TreeSet<>(List.of(4))));
    }
}