package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {

    @Test
    public void equalsTest() {
        Pair<String, Integer> pair1 = new Pair<>("key", 1);
        Pair<String, Integer> pair2 = new Pair<>("key", 1);
        Pair<String, Integer> pair3 = new Pair<>("key2", 2);
        Pair<String, Integer> pair4 = new Pair<>("key", 2);
        Pair<String, Integer> pair5 = new Pair<>(null, null);
        Pair<String, Integer> pair6 = new Pair<>(null, null);
        Pair<String, Integer> pair7 = null;
        String notAPair = "Not a Pair";

        // Test for reflexivity
        assertTrue(pair1.equals(pair1));

        // Test for symmetry
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair1));

        // Test for transitivity
        Pair<String, Integer> pair8 = new Pair<>("key", 1);
        assertTrue(pair1.equals(pair2));
        assertTrue(pair2.equals(pair8));
        assertTrue(pair1.equals(pair8));

        // Test for inequality with different keys and values
        assertFalse(pair1.equals(pair3));
        assertFalse(pair3.equals(pair1));

        // Test for inequality with the same keys but different values
        assertFalse(pair1.equals(pair4));
        assertFalse(pair4.equals(pair1));

        // Test when both pairs have null keys and values
        assertTrue(pair5.equals(pair6));
        assertTrue(pair6.equals(pair5));

        // Test comparing with null
        assertFalse(pair1.equals(pair7));

        // Test comparing with an object of a different class
        assertFalse(pair1.equals(notAPair));
    }
}