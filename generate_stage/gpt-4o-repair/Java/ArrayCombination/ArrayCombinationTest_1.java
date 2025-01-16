package com.thealgorithms.backtracking;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ArrayCombinationTest {

    @Test
    public void combinationTest() {
        // Test when n = 5 and k = 3
        List<TreeSet<Integer>> result = ArrayCombination.combination(5, 3);

        List<TreeSet<Integer>> expected = new ArrayList<>();
        expected.add(new TreeSet<>(Arrays.asList(1, 2, 3)));
        expected.add(new TreeSet<>(Arrays.asList(1, 2, 4)));
        expected.add(new TreeSet<>(Arrays.asList(1, 2, 5)));
        expected.add(new TreeSet<>(Arrays.asList(1, 3, 4)));
        expected.add(new TreeSet<>(Arrays.asList(1, 3, 5)));
        expected.add(new TreeSet<>(Arrays.asList(1, 4, 5)));
        expected.add(new TreeSet<>(Arrays.asList(2, 3, 4)));
        expected.add(new TreeSet<>(Arrays.asList(2, 3, 5)));
        expected.add(new TreeSet<>(Arrays.asList(2, 4, 5)));
        expected.add(new TreeSet<>(Arrays.asList(3, 4, 5)));

        assertEquals(expected, result);

        // Test when n = 4 and k = 0
        List<TreeSet<Integer>> result2 = ArrayCombination.combination(4, 0);
        assertNull(result2);

        // Test when n = 0 and k = 2
        List<TreeSet<Integer>> result3 = ArrayCombination.combination(0, 2);
        assertNull(result3);
    }

    @Test
    public void edgeCasesTest() {
        // Test when n is negative
        List<TreeSet<Integer>> result4 = ArrayCombination.combination(-5, 3);
        assertNull(result4);
    }
}