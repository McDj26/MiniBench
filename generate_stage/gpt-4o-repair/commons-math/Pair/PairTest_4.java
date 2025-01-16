package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void equalsTest() {
        // Test equality with itself
        Pair<String, Integer> pair1 = new Pair<>("key1", 1);
        assertTrue(pair1.equals(pair1), "Pair should be equal to itself");

        // Test equality with another object of the same value
        Pair<String, Integer> pair2 = new Pair<>("key1", 1);
        assertTrue(pair1.equals(pair2), "Pairs with same key and value should be equal");
        assertTrue(pair2.equals(pair1), "Equality should be symmetric");

        // Test with different key
        Pair<String, Integer> pair3 = new Pair<>("key2", 1);
        assertFalse(pair1.equals(pair3), "Pairs with different keys should not be equal");

        // Test with different value
        Pair<String, Integer> pair4 = new Pair<>("key1", 2);
        assertFalse(pair1.equals(pair4), "Pairs with different values should not be equal");

        // Test with null key and/or value
        Pair<String, Integer> pair5 = new Pair<>(null, 1);
        Pair<String, Integer> pair6 = new Pair<>(null, 1);
        assertTrue(pair5.equals(pair6), "Pairs with null keys and same values should be equal");

        Pair<String, Integer> pair7 = new Pair<>(null, null);
        assertTrue(pair7.equals(pair7), "Pairs with null keys and values should be equal to themselves");

        // Test comparison with null and other object types
        assertFalse(pair1.equals(null), "Pair should not be equal to null");
        assertFalse(pair1.equals("someString"), "Pair should not be equal to an object of a different type");
    }
}