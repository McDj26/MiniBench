package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    private class TestSeries extends Series {
        public TestSeries(Comparable key) {
            super(key);
        }

        public TestSeries(Comparable key, String description) {
            super(key, description);
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
        public boolean canEqual(Object other) {
            return other instanceof TestSeries;
        }
    }

    @Test
    public void equalsTest() {
        // Test equality with itself
        Series series1 = new TestSeries("TestKey", "TestDescription");
        assertTrue(series1.equals(series1), "Series should be equal to itself");

        // Test equality with another object of the same class with the same keys and description
        Series series2 = new TestSeries("TestKey", "TestDescription");
        assertTrue(series1.equals(series2), "Series with the same key and description should be equal");
        
        // Test equality with another object of a different class
        Object differentClassObject = new Object();
        assertFalse(series1.equals(differentClassObject), "Series should not be equal to an object of a different class");

        // Test inequality with another series of the same class but with a different key
        Series series3 = new TestSeries("DifferentKey", "TestDescription");
        assertFalse(series1.equals(series3), "Series with different keys should not be equal");

        // Test inequality with another series of the same class but with a different description
        Series series4 = new TestSeries("TestKey", "DifferentDescription");
        assertFalse(series1.equals(series4), "Series with different descriptions should not be equal");

        // Test equality with null
        assertFalse(series1.equals(null), "Series should not be equal to null");
    }
}