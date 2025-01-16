package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    @Test
    public void equalsTest() {
        Pair<String, Integer> pair1 = new Pair<>("key1", 1);
        Pair<String, Integer> pair2 = new Pair<>("key2", 2); // Different key and value from pair1
        Pair<String, Integer> pair3 = new Pair<>("key1", null); // Different value type (null) but same key as pair1
        Pair<String, String> pair4 = new Pair<>("key", "value"); // Different type of objects (string keys vs string values)
        assertFalse(pair1.equals(pair2)); // Should not be equal as keys are different
        assertTrue(pair1.equals(pair3)); // Should be equal as keys are same despite different value types
        assertFalse(pair1.equals(pair4)); // Should not be equal as types are different
        assertFalse(pair1.equals(null)); // Should not be equal to null
        assertFalse(null == pair1); // null should never be equal to any non-null object
    }
}