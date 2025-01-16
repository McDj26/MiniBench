package org.apache.commons.math4.legacy.core;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PairTest {
    @Test
    public void equalsTest() {
        // Create two pairs with different objects but same values
        Pair<String, Integer> pair1 = Pair.create("test", 1);
        Pair<String, Integer> pair2 = Pair.create("test", 1);
        assertTrue(pair1.equals(pair2), "Equal pairs should return true");
        assertEquals(pair1.hashCode(), pair2.hashCode(), "Hash codes should be equal for equal pairs");
        
        // Create a pair with null key and value
        Pair<?, ?> nullPair = Pair.create(null, null);
        // Create another pair with null key and value to test equality
        Pair<?, ?> anotherNullPair = Pair.create(null, null);
        assertTrue(nullPair.equals(anotherNullPair), "Null pairs should return true");
        assertEquals(nullPair.hashCode(), anotherNullPair.hashCode(), "Hash codes for null pairs should be equal");
        
        // Create a pair with non-null key and value
        Pair<?, ?> nonNullPair = Pair.create("key", "value");
        // Create another pair with different non-null key and value to test inequality
        Pair<?, ?> differentNonNullPair = Pair.create("differentKey", "value");
        assertFalse(nonNullPair.equals(differentNonNullPair), "Unequal pairs should return false");
        assertNotEquals(nonNullPair.hashCode(), differentNonNullPair.hashCode(), "Hash codes for unequal pairs should be different");
        
        // Test the case where the given object is not an instance of Pair
        Object notAPairObject = new Object();
        assertFalse(pair1.equals(notAPairObject), "Object should not be equal to a Pair");
    }
}