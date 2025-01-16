package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void equalsTest() {
        Pair<String, Integer> pair1 = new Pair<>("key", 123);
        Pair<String, Integer> pair2 = new Pair<>("key", 123);
        Pair<String, Integer> pair3 = new Pair<>("key", 456);
        Pair<String, Integer> pair4 = new Pair<>("differentKey", 123);
        Pair<String, Integer> pair5 = new Pair<>(null, null);
        Pair<String, Integer> pair6 = new Pair<>(null, null);
        Pair<String, Integer> pair7 = new Pair<>("key", null);

        // Test equal pairs
        assertTrue(pair1.equals(pair2), "Pair1 should be equal to Pair2");

        // Test same reference
        assertTrue(pair1.equals(pair1), "Pair should be equal to itself");

        // Test pairs with different values
        assertFalse(pair1.equals(pair3), "Pair1 should not be equal to Pair3");

        // Test pairs with different keys
        assertFalse(pair1.equals(pair4), "Pair1 should not be equal to Pair4");

        // Test null comparison
        assertFalse(pair1.equals(null), "Pair1 should not be equal to null");

        // Test different types
        assertFalse(pair1.equals("a string"), "Pair1 should not be equal to a string");

        // Test both pairs have null keys and values
        assertTrue(pair5.equals(pair6), "Pair5 should be equal to Pair6");

        // Test a pair with only null values
        assertFalse(pair1.equals(pair7), "Pair1 should not be equal to Pair7");

        // Test pair with null key and non-null value against a similar non-null pair
        Pair<String, Integer> pair8 = new Pair<>(null, 123);
        assertFalse(pair1.equals(pair8), "Pair1 should not be equal to Pair8");

        // Test pair with null value and non-null key against a similar non-null pair
        Pair<String, Integer> pair9 = new Pair<>("key", null);
        assertFalse(pair9.equals(pair1), "Pair9 should not be equal to Pair1");
    }
}