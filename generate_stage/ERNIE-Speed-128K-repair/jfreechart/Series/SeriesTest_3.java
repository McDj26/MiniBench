package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    
    @Test
    public void equalsTest() {
        // Test 1: Compare null
        Series series = new Series("Key1");
        assertFalse(series.equals(null)); // Should return false when comparing with null
        
        // Test 2: Compare with different instances of Series but same key and description
        Series series1 = new Series("Key1");
        Series series2 = new Series("Key1"); // Same key as series1
        assertTrue(series1.equals(series2)); // Should return true since keys are the same
        assertEquals(series1.hashCode(), series2.hashCode()); // Hash codes should be equal for equal objects
        
        // Test 3: Compare with different instances of Series but different keys and same description
        Series seriesA = new Series("KeyA"); // Different key than series1/series2
        Series seriesB = new Series("KeyB"); // Different key than seriesA but same description as seriesA
        assertFalse(seriesA.equals(seriesB)); // Should return false since keys are different
        assertNotEquals(seriesA.hashCode(), seriesB.hashCode()); // Hash codes should be different for unequal objects
        assertNotEquals(seriesB, seriesA); // Equality should be asymmetric and should fail for non-equal objects
        assertEquals(seriesA, seriesA); // Equality should be reflexive and should pass for the same object
        assertEquals(new Series("KeyA"), new Series("KeyA")); // Equality should pass for two instances of same type and data (in this case, key)
        assertFalse(new Series("KeyA").equals(new Series("KeyB"))); // Equality should fail for different instances of same type but different data (different keys)
        assertFalse(new Series("KeyA").equals("NotASeries")); // Equality should fail for different types of objects (different classes) even if data is similar in structure or value
        assertFalse(new Series("KeyA").equals(null)); // Equality should fail when comparing with null
        assertFalse(new Series("KeyA").equals("")); // Equality should fail when comparing with an empty string even if it looks like a string representation of a series's key is present (like it is some other object's instance or data)
    }
}