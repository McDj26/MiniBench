package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    @Test
    public void equalsTest() {
        // Test case for comparing two Pair objects that are equal
        Pair<String, Integer> pair1 = new Pair<>("key", 5);
        Pair<String, Integer> pair2 = new Pair<>("key", 5);
        assertTrue(pair1.equals(pair2)); // Should return true as both pairs have the same key and value
        assertTrue(pair2.equals(pair1)); // For symmetry

        // Test case for comparing a Pair object with null
        Pair<?, ?> pairNullKey = null; // assuming a null key means an invalid Pair
        assertFalse(pairNullKey.equals(pair1)); // Should return false as the key is null
        assertFalse(pairNullValuePairNull.equals(pairNullValue)); // Assuming pairNullValue is a Pair with null value
        assertFalse(pairNullValuePairNull.equals(null)); // Assuming pairNullValuePairNull is not null
        assertFalse(pairNullValuePairNull == null); // Should return false as it is comparing the Pair object with null, not comparing its value
        assertFalse(pairNullValuePairNull != null); // Should return true as it is comparing the Pair object with itself using != operator

        // Test case for comparing two Pair objects that are not equal
        Pair<String, Integer> pair3 = new Pair<>("anotherKey", 5); // different key but same value
        assertFalse(pair1.equals(pair3)); // Should return false as the keys are different
        assertFalse(pair3.equals(pair1)); // Should return false as well for symmetry
    }
}