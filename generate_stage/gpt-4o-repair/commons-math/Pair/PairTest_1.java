package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    
    @Test
    public void equalsTest() {
        // Create test objects
        Pair<String, Integer> pair1 = new Pair<>("key1", 1);
        Pair<String, Integer> pair2 = new Pair<>("key1", 1);
        Pair<String, Integer> pair3 = new Pair<>("key2", 2);
        Pair<String, Integer> pairWithNullValues = new Pair<>(null, null);
        Pair<String, Integer> pairWithNullKey = new Pair<>(null, 1);
        Pair<String, Integer> pairWithNullValue = new Pair<>("key1", null);

        // Test equal pairs
        assertTrue(pair1.equals(pair1), "A pair should be equal to itself.");
        assertTrue(pair1.equals(pair2), "Pairs with the same key and value should be equal.");
        
        // Test unequal pairs
        assertFalse(pair1.equals(pair3), "Pairs with different keys and values should not be equal.");
        
        // Test null and different class comparisons
        assertFalse(pair1.equals(null), "A pair should not be equal to null.");
        assertFalse(pair1.equals("Some String"), "A pair should not be equal to an object of a different class.");

        // Test pairs with null values
        assertTrue(pairWithNullValues.equals(pairWithNullValues), "Pairs with null key and value should be equal to themselves.");
        assertTrue(pairWithNullValues.equals(new Pair<>(null, null)), "Different instances of pairs with null keys and values should be equal.");

        assertFalse(pair1.equals(pairWithNullValues), "A pair with non-null values should not be equal to a pair with null values.");
        assertFalse(pairWithNullKey.equals(pair1), "A pair with a null key should not be equal to a pair with a non-null key.");
        assertFalse(pairWithNullValue.equals(pair1), "A pair with a null value should not be equal to a pair with a non-null value.");
    }
}