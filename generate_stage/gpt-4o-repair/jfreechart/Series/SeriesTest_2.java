package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// A simple concrete subclass of Series for testing purposes
class TestSeries extends Series {
    public TestSeries(Comparable key, String description) {
        super(key, description);
    }

    @Override
    public int getItemCount() {
        return 0;  // Simplified for testing
    }

    @Override
    public boolean canEqual(Object other) {
        return other instanceof TestSeries;
    }
}

public class SeriesTest {
    @Test
    public void equalsTest() {
        // Test equality with itself
        TestSeries series1 = new TestSeries("Key1", "Description1");
        assertTrue(series1.equals(series1), "An object should be equal to itself");

        // Test equality between identical objects
        TestSeries series2 = new TestSeries("Key1", "Description1");
        assertTrue(series1.equals(series2), "Objects with the same properties should be equal");
        assertTrue(series2.equals(series1), "Equality should be symmetric");

        // Test equality with null
        assertFalse(series1.equals(null), "An object should not be equal to null");

        // Test inequality with different key
        TestSeries series3 = new TestSeries("Key2", "Description1");
        assertFalse(series1.equals(series3), "Objects with different keys should not be equal");

        // Test inequality with different description
        TestSeries series4 = new TestSeries("Key1", "Description2");
        assertFalse(series1.equals(series4), "Objects with different descriptions should not be equal");

        // Test inequality with different class
        Object obj = new Object();
        assertFalse(series1.equals(obj), "An object should not be equal to an instance of a different class");
    }
}