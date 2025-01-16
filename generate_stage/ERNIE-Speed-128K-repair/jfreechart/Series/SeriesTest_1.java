package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    @Test
    public void equalsTest() {
        Series seriesA = new Series("KeyA", "DescriptionA"); // Assuming constructor exists
        Series seriesB = new Series("KeyB", "DescriptionB"); // Assuming constructor exists
        Series seriesC = new Series("KeyA", "DescriptionA"); // Same key and description as seriesA
        Series seriesD = new Object(); // Assuming this is a different object type with no relation to Series class
        Series seriesE = (Series) seriesA.clone(); // Assuming clone method works correctly
        
        // Testing the equals method with different scenarios
        assertTrue(seriesA.equals(seriesA)); // Same object should return true
        assertFalse(seriesA.equals(seriesB)); // Different instances with different attributes should return false
        assertTrue(seriesA.equals(seriesC)); // Same attributes should return true even if instances are different
        assertFalse(seriesA.equals(seriesD)); // Objects of different types should return false
        assertTrue(seriesA.equals(seriesE)); // Clone of the same object should return true
        
        // Testing the equals method with null input
        assertFalse(seriesA.equals(null)); // Null should always return false
    }
}