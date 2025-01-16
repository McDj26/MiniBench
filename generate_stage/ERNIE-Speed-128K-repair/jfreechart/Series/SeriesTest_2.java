package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    @Test
    public void equalsTest() {
        Series seriesA = new Series("KeyA", "DescriptionA"); // Assuming constructor exists
        Series seriesB = new Series("KeyA", "DescriptionA"); // Create a similar series
        assertTrue(seriesA.equals(seriesB)); // Assert seriesA equals seriesB
        assertNotEquals(seriesA, null); // Assert seriesA is not null and not equal to null
        assertNotEquals(seriesA, new Object()); // Assert seriesA is not equal to a generic Object instance
        assertNotEquals(seriesA, "SomeString"); // Assert seriesA is not equal to a string
        assertNotEquals(seriesA, seriesB.getKey()); // Assert seriesA is not equal to another series' key alone
        assertNotEquals(seriesA, seriesB.getDescription()); // Assert seriesA is not equal to another series' description alone
        assertEquals(seriesA, seriesA); // Assert seriesA is equal to itself
        assertEquals(seriesB, seriesB); // Assert seriesB is equal to itself (a trivial case)
        assertEquals(seriesA, new Series("KeyA", null)); // Assert seriesA can be equal to another series with null description
        assertNotEquals(seriesA, new Series("KeyB", "DescriptionA")); // Assert seriesA is not equal to another series with different key
        assertNotEquals(seriesA, new Series("KeyA", "DescriptionB")); // Assert seriesA is not equal to another series with different description
    }
}