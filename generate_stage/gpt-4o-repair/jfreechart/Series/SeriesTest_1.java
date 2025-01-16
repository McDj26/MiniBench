package org.jfree.data.general;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        Series series1 = new TestSeries("Key1", "Description1");
        Series series2 = new TestSeries("Key1", "Description1");
        Series series3 = new TestSeries("Key2", "Description2");
        Series series4 = new TestSeries("Key1");

        // Check reflexivity
        assertTrue(series1.equals(series1), "A series should be equal to itself.");

        // Check symmetry
        assertTrue(series1.equals(series2), "series1 should be equal to series2.");
        assertTrue(series2.equals(series1), "series2 should be equal to series1.");

        // Check transitivity
        Series series5 = new TestSeries("Key1", "Description1");
        assertTrue(series1.equals(series2), "series1 should be equal to series2.");
        assertTrue(series2.equals(series5), "series2 should be equal to series5.");
        assertTrue(series1.equals(series5), "series1 should be equal to series5.");

        // Check consistency
        assertTrue(series1.equals(series2), "series1 should consistently be equal to series2.");
        assertTrue(series1.equals(series2), "series1 should consistently be equal to series2.");

        // Check null handling
        assertFalse(series1.equals(null), "A series should not be equal to null.");

        // Different key and description
        assertFalse(series1.equals(series3), "series1 should not be equal to series3 with a different key.");
        
        // Check that series4 is not equal to series1 due to difference in description
        assertFalse(series1.equals(series4), "series1 should not be equal to series4 with different description.");
        
        // Check that series can equal another instance of its subclass
        assertTrue(series1.canEqual(series2), "series1 should be able to equal series2.");
        assertFalse(series1.canEqual(new Object()), "series1 should not be able to equal a non-series object.");
    }
}