package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    @Test
    public void equalsTest() {
        // Create two pairs with different values but same key and value
        Pair<String, Integer> pair1 = new Pair<>("key", 1);
        Pair<String, Integer> pair2 = new Pair<>("key", 1);
        assertTrue(pair1.equals(pair2)); // They should be equal
        assertEquals(pair1.hashCode(), pair2.hashCode()); // They should have the same hash code
        assertTrue(pair2.equals(pair1)); // Also checking the reverse comparison

        // Now, create two pairs with the same key but different values
        Pair<String, Integer> pair3 = new Pair<>("key", 2); // Different value than pair1 and pair2
        assertFalse(pair1.equals(pair3)); // They should not be equal because of different values
        assertNotEquals(pair1.hashCode(), pair3.hashCode()); // They should have different hash codes due to different values
        assertFalse(pair3.equals(pair1)); // Also checking the reverse comparison for clarity

        // Testing null values
        Pair<?, ?> nullKeyNullValuePair = new Pair<>(null, null); // Creating a pair with null key and value
        assertTrue(nullKeyNullValuePair.equals(new Pair<>(null, null))); // Null key and value pairs should be equal
        assertNotEquals(nullKeyNullValuePair, pair1); // A null key and value pair should not be equal to any other pair (especially with non-null key or value)
    }
}