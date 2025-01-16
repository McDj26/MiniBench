package org.jfree.data.general;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {

    private static class TestSeries extends Series {
        TestSeries(Comparable key) {
            super(key);
        }

        TestSeries(Comparable key, String description) {
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
        TestSeries series1 = new TestSeries("Series1", "Description1");
        TestSeries series2 = new TestSeries("Series1", "Description1");
        TestSeries series3 = new TestSeries("Series3", "Description3");

        // Test for reflexivity
        assertTrue(series1.equals(series1));

        // Test for symmetry
        assertTrue(series1.equals(series2));
        assertTrue(series2.equals(series1));

        // Test for transitivity
        TestSeries series4 = new TestSeries("Series1", "Description1");
        assertTrue(series1.equals(series2));
        assertTrue(series2.equals(series4));
        assertTrue(series1.equals(series4));

        // Test for consistency
        assertTrue(series1.equals(series2));
        assertTrue(series1.equals(series2));

        // Test for null comparison
        assertFalse(series1.equals(null));

        // Test different descriptions
        TestSeries seriesWithDifferentDescription = new TestSeries("Series1", "Description2");
        assertFalse(series1.equals(seriesWithDifferentDescription));

        // Test different keys
        assertFalse(series1.equals(series3));

        // Test different class comparison
        assertFalse(series1.equals(new Object()));
    }
}