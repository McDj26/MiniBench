package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void equalsTest() {
        Pair<String, Integer> pair1 = new Pair<>("key", 123);
        Pair<String, Integer> pair2 = new Pair<>("key", 123);
        Pair<String, Integer> pair3 = new Pair<>("key2", 123);
        Pair<String, Integer> pair4 = new Pair<>("key", 456);
        Pair<String, Integer> pair5 = new Pair<>(null, null);
        Pair<String, Integer> pair6 = new Pair<>(null, null);

        // Test reflexivity
        assertTrue(pair1.equals(pair1));

        // Test symmetry
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair1));

        // Test transitivity
        Pair<String, Integer> pair7 = new Pair<>("key", 123);
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair7));
        assertTrue(pair1.equals(pair7));

        // Test consistency
        assertTrue(pair1.equals(pair2));
        assertTrue(pair1.equals(pair2));

        // Test null
        assertFalse(pair1.equals(null));

        // Test different key
        assertFalse(pair1.equals(pair3));

        // Test different value
        assertFalse(pair1.equals(pair4));

        // Test with null attributes
        assertTrue(pair5.equals(pair6));

        Pair<String, Integer> pair8 = new Pair<>(null, 123);
        Pair<String, Integer> pair9 = new Pair<>(null, 456);
        // Test with one null key
        assertFalse(pair8.equals(pair1));
        assertFalse(pair1.equals(pair8));
        
        // Test with one null key among null pairs
        assertFalse(pair8.equals(pair9));
    }
}