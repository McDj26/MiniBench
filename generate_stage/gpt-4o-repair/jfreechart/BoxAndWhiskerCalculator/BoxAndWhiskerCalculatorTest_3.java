package org.jfree.data.statistics;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxAndWhiskerCalculatorTest {

    @Test
    public void calculateQ1Test() {
        // Test with empty list
        List<Double> emptyList = new ArrayList<>();
        assertEquals(Double.NaN, BoxAndWhiskerCalculator.calculateQ1(emptyList), "Q1 of an empty list should be NaN");

        // Test with a list with one element
        List<Double> oneElementList = Arrays.asList(5.0);
        assertEquals(5.0, BoxAndWhiskerCalculator.calculateQ1(oneElementList), "Q1 of a one element list should be the element itself");

        // Test with a list with odd number of elements
        List<Double> oddList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        assertEquals(1.5, BoxAndWhiskerCalculator.calculateQ1(oddList), 0.0001, "Q1 should be the median of the first half");

        // Test with a list with even number of elements
        List<Double> evenList = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        assertEquals(1.5, BoxAndWhiskerCalculator.calculateQ1(evenList), 0.0001, "Q1 should be the median of the first half");

        // Test with a list with null values
        List<Double> listWithNulls = Arrays.asList(1.0, null, 3.0, 4.0);
        assertThrows(NullPointerException.class, () -> {
            BoxAndWhiskerCalculator.calculateQ1(listWithNulls);
        }, "NullPointerException should be thrown if list contains nulls");

        // Test with a list containing NaN values
        List<Double> listWithNaNs = Arrays.asList(1.0, Double.NaN, 3.0, 4.0);
        double result = BoxAndWhiskerCalculator.calculateQ1(listWithNaNs);
        assertTrue(Double.isNaN(result), "Result should be NaN if list contains NaN");
    }
}