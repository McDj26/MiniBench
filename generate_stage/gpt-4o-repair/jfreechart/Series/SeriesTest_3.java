package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    @Test
    public void equalsTest() {
        // Create two Series objects with the same key and description
        Series series1 = new ConcreteSeries("key1", "description1");
        Series series2 = new ConcreteSeries("key1", "description1");
        
        // Test reflexivity
        assertTrue(series1.equals(series1));
        
        // Test symmetry
        assertTrue(series1.equals(series2));
        assertTrue(series2.equals(series1));
        
        // Test transitivity
        Series series3 = new ConcreteSeries("key1", "description1");
        assertTrue(series1.equals(series2));
        assertTrue(series2.equals(series3));
        assertTrue(series1.equals(series3));

        // Test consistency
        assertTrue(series1.equals(series2));
        assertTrue(series1.equals(series2));

        // Test null handling
        assertFalse(series1.equals(null));

        // Test different keys
        Series series4 = new ConcreteSeries("key2", "description1");
        assertFalse(series1.equals(series4));

        // Test different descriptions
        Series series5 = new ConcreteSeries("key1", "description2");
        assertFalse(series1.equals(series5));
    }

    // A concrete implementation of the abstract Series class for testing purposes
    private class ConcreteSeries extends Series {
        // Constructor matching the signatures in the Series class
        public ConcreteSeries(Comparable key) {
            super(key);
        }

        public ConcreteSeries(Comparable key, String description) {
            super(key, description);
        }

        // Implement abstract method getItemCount
        @Override
        public int getItemCount() {
            return 0;
        }

        // Implement the canEqual method
        @Override
        public boolean canEqual(Object other) {
            return other instanceof ConcreteSeries;
        }
    }
}