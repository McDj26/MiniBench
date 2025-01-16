package org.apache.commons.math4.legacy.core;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    @Test
    public void equalsTest() {
        // Test case for comparing two Pair objects with the same key and value
        Pair<String, Integer> pair1 = Pair.create("key", 5);
        Pair<String, Integer> pair2 = Pair.create("key", 5);
        assertTrue(pair1.equals(pair2)); // should return true since both pairs have the same key and value
        assertEquals(pair1.hashCode(), pair2.hashCode()); // they should also have the same hashcode
        assertTrue(pair2.equals(pair1)); // for symmetry, this should also return true
        
        // Test case for comparing Pair objects with different keys but same values
        Pair<String, Integer> pair3 = Pair.create("key1", 5); // different key but same value as pair1 and pair2
        assertFalse(pair1.equals(pair3)); // should return false since keys are different even though values are the same
        assertFalse(pair3.equals(pair1)); // this should also return false for symmetry
        assertFalse(pair2.equals(pair3)); // should return false for the same reason as above
        assertNotEquals(pair1.hashCode(), pair3.hashCode()); // they should have different hashcodes since keys are different
        
        // Test case for comparing Pair objects with null key and value
        Pair<?, ?> nullPair = Pair.<Object, Object>create(null, null); // null key and value
        assertTrue(nullPair.equals(Pair.<Object, Object>create(null, null))); // two null pairs should be equal to each other
        assertFalse(nullPair.equals(pair1)); // a null pair should not be equal to a non-null pair with values even if those values are the same as the null values in this case
        assertNotEquals(nullPair.hashCode(), pair1.hashCode()); // they should have different hashcodes since one is null and the other is not
        
        // Test case for comparing a Pair object with non-Pair object
        assertFalse(pair1.equals("string")); // should return false since a string is not a Pair object
    }
}